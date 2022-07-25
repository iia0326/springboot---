package com.kangyi.quartz.controller;

import com.kangyi.mapper.QuartzBeanMapper;
import com.kangyi.pojo.QuartzBean;
import com.kangyi.quartz.QuartzUtils;
import com.kangyi.service.QuartzBeanService;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/quartz")
//@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
//        maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
public class QuartzController {
    //注入任务调度
    @Autowired
    private Scheduler scheduler;

    @Autowired
    QuartzBeanService quartzBeanService;



    @ResponseBody
    @RequestMapping(path = "/list")
    public Map<String, Object> getList(
//            @RequestBody
                    Map<String, Object> map,
            HttpSession session
    ) {

//        System.out.println("  !" +map.toString());
        String sortField="insertTime";
        String sortType="desc";


//        String userId= String.valueOf( map.get( "userId" ) );
        String JobName= String.valueOf( map.get( "JobName" ) );
        Integer status=(Integer)map.get( "status" );
        Integer pno1=(Integer)map.get( "pno" );
        Integer psize1=(Integer)map.get( "psize" );
//         System.out.println("@#$ :"+psize1);
//         System.out.println("@#$2 :"+map.get( "psize" ));
//        Long userId=null;
////        if (map.get( "userId" )!=null){
////            userId= Long.parseLong( map.get( "userId" ).toString() );
////            System.out.println("$$  !! 普通userId: "+userId);
////        }
        if (pno1 == null){
            pno1=1;
        }
        if (psize1==null){
            psize1=20;
        }
        if (status==null){
            status=0;
        }
        if ("ascend".equals( String.valueOf(map.get( "sortType" )) )){
            sortType="asc";
        }else  if("descend".equals( String.valueOf(map.get( "sortType" ) ))){
            sortType="desc";
        }

        if (map.get( "sortField" )!=null){
            sortField= String.valueOf( map.get( "sortField" ) );
        }

        Map<String, Object> listForPage = quartzBeanService.getListForPage( status, JobName, pno1, psize1);
//        System.out.println("@#$111111"+listForPage);
//        List<Order> orders = (List<Order>)listForPage.get( "order" );
        return  listForPage;
    }


    @RequestMapping("/createJob")
    @ResponseBody
    public String  createJob(String jobName,String cronExpression)  {
        try {
            //进行测试所以写死
//            jobName="test3";
//            cronExpression="* 27 20 */1 * ?";

            System.out.println("@#$time :"+cronExpression);
            QuartzBean quartzBean=new QuartzBean();
            quartzBean.setJobClass("com.kangyi.quartz.GuijiQuartz");
            quartzBean.setJobName(jobName);
            quartzBean.setStatus( 1 );
            quartzBean.setCronExpression(cronExpression);
            quartzBeanService.insertOne( quartzBean );
            QuartzUtils.createScheduleJob(scheduler,quartzBean);
        } catch (Exception e) {
            return "创建失败";
        }
        return "创建成功";
    }


    @Transactional
    @RequestMapping("/pauseJob")
    @ResponseBody
    public String  pauseJob(int jobId)  {
        try {
            QuartzBean quartzBean = quartzBeanService.selectOne( jobId );
            quartzBean.setStatus( 2 );
            quartzBeanService.updateOne( quartzBean );
            boolean b = scheduler.checkExists( JobKey.jobKey( quartzBean.getJobName() ) );
            if(!b) {
                quartzBeanService.delectOne(jobId);
                createJob(quartzBean.getJobName(),quartzBean.getCronExpression());
            }
            QuartzUtils.pauseScheduleJob (scheduler,quartzBean.getJobName());
        } catch (Exception e) {
            return "暂停失败";
        }
        return "暂停成功";
    }
    @Transactional
    @RequestMapping("/delect")
    @ResponseBody
    public String  delect(int jobId)  {
        try {
            QuartzBean quartzBean = quartzBeanService.selectOne( jobId );
//            System.out.println("@#$1 "+jobId);
            int a=quartzBeanService.delectOne(jobId);
//            System.out.println("3");
            if(a<1){throw new Exception( "sql失败" );}
            boolean b = scheduler.checkExists( JobKey.jobKey( quartzBean.getJobName() ) );
            if(b) {
//                System.out.println("@#$2");
                QuartzUtils.deleteScheduleJob( scheduler, quartzBean.getJobName() );
            }else {
                return "删除成功";
            }
        } catch (Exception e) {
            return "删除失败"+e;
        }
        return "删除成功";
    }

    @Transactional
    @RequestMapping("/runOnce")
    @ResponseBody
    public String  runOnce(int jobId)  {
        System.out.println("runone");
        try {

            QuartzBean quartzBean = quartzBeanService.selectOne( jobId );
            quartzBean.setStatus( 1 );
            boolean b = scheduler.checkExists( JobKey.jobKey( quartzBean.getJobName() ) );
            if(b) {
                int i = quartzBeanService.updateOne( quartzBean );
                if(i<1){throw new Exception( "sql失败" );}
            }else {
                quartzBeanService.delectOne(jobId);
                createJob(quartzBean.getJobName(),quartzBean.getCronExpression());
            }
            QuartzUtils.runOnce (scheduler,quartzBean.getJobName());

        } catch (Exception e) {
            return "运行一次失败";
        }
        return "运行一次成功";
    }
    @Transactional
    @RequestMapping("/resume")
    @ResponseBody
    public String  resume(int jobId)  {
        try {
            QuartzBean quartzBean = quartzBeanService.selectOne( jobId );
            quartzBean.setStatus( 1 );
            boolean b = scheduler.checkExists( JobKey.jobKey( quartzBean.getJobName() ) );
            if(b) {
                int i = quartzBeanService.updateOne( quartzBean);
                if(i<1){throw new Exception( "sql失败" );}

            }else {
                quartzBeanService.delectOne(jobId);
                createJob(quartzBean.getJobName(),quartzBean.getCronExpression());
            }
            QuartzUtils.resumeScheduleJob(scheduler,quartzBean.getJobName());

        } catch (Exception e) {
            return "启动失败";
        }
        return "启动成功";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String  update(String jobName,String cronExpression,Integer jobId)  {
        //进行测试所以写死
//            quartzBean.setJobName("test1");
//            quartzBean.setCronExpression("10 * * * * ?");
        System.out.println(jobId+" @#$ "+jobName+"   " +cronExpression);
        try {

            QuartzBean quartzBean = new QuartzBean();
            quartzBean.setJobName( jobName );
            quartzBean.setId( jobId );
            quartzBean.setStatus( 1 );
            quartzBean.setCronExpression( cronExpression );
            quartzBean.setJobClass("com.hjljy.blog.Quartz.GuijiQuartz");
            int i = quartzBeanService.updateOne( quartzBean );
            if(i<1){throw new Exception( "sql失败" );}
            boolean b = scheduler.checkExists( JobKey.jobKey( quartzBean.getJobName() ) );
            if(b) {
                QuartzUtils.updateScheduleJob(scheduler,quartzBean);
            }else {
                quartzBeanService.delectOne(jobId);
                createJob(quartzBean.getJobName(),quartzBean.getCronExpression());
            }


        } catch (Exception e) {
            return "修改启动失败";
        }
        return "修改启动成功";
    }
}