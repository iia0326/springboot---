layui.use('dropdown', function(){
    var dropdown = layui.dropdown
    dropdownMenu = dropdown.render({
        elem: '.user-info' //可绑定在任意元素中，此处以上述按钮为例
        ,data: [{
            title: '修改密码'
            ,id: 100
            // ,href: '#'
        },{
            title: '退出登录'
            ,id: 101
        }]
        ,id:'user-info'
        //菜单被点击的事件
        ,click: function(obj){
            console.log(obj);
            // layer.msg('回调返回的参数已显示再控制台');
            if(obj.id == 101){
                layer.confirm('正在退出登录是否继续？', {
                    title:'提示',
                    icon:3,
                    btn: ['确认', '取消'] //可以无限个按钮
                }, function(index, layero){
                    //按钮【按钮一】的回调
                    location.href = baseUrl+'/login/logout'
                });
            }else{
                // var iframe = document.getElementById("iframe")
                // iframe.src = baseUrl+'/user/password/page'
                handleChangeTab(1,5)
                handleChangeMenu(5,'user/password/page')
            }
        }
    });
});
//切换菜单显示和隐藏样式
$('#toggle-menu').on('click',function(){
    var status = $('#menu').css('display')
    $('#menu').addClass('toggle-menu-start')
    setTimeout(() => {
        $(".toggle-menu-bg").fadeIn(500)
        $('#menu').addClass('toggle-menu-end')
    })
})
//点击菜单背景关闭菜单
$('.toggle-menu-bg').on('click',function(){
    $(this).fadeOut(300)
    $('#menu').removeClass('toggle-menu-end')
    setTimeout(() => {
        $('#menu').removeClass('toggle-menu-start')
    },500)
})
menuList[0].children[0].active = true
//tabbar的数据
var tabbarList = [menuList[0].children[0]]
//渲染tabbar数据
function renderTabbar(){
    $('.p-tab .layui-tab-title').empty()
    tabbarList.forEach((item,index) => {
        $('.p-tab .layui-tab-title').append(`
            <li ${item.active? 'class="layui-this"':''} 
                data-id="${item.id}" 
                onclick="handleChangeMenu(${item.id},'${item.url}')">
                ${item.name}
                <i class="layui-icon layui-icon-close" onclick="handleCloseTab(window.event,${item.id})"></i>
            </li>
        `)
    })
}
//默认渲染tabbar
renderTabbar()
//点击菜单的时候切换tabbar的选中状态
function handleChangeTab(fatherId,childId){
    let father = menuList.filter(item => item.id == fatherId)[0]
    let child = father.children.filter(item => item.id == childId)[0]
    let tabbarSet = new Set(tabbarList)
    tabbarList = Array.from(tabbarSet.add(child))
    tabbarList.forEach(item => {
        item.active = false
        if(item.id == childId){
            item.active = true
        }
    })
    renderTabbar()
}
//切换tabbar的时候切换菜单的选中状态
function handleChangeMenu(id,url){
    console.log(id,url)
    $('#menu .menu-item').each((index,item) => {
        $(item).removeClass('layui-this')
        if(item.dataset.id == id){
            let menuBase = $(item).parent().parent()
            if(!menuBase.hasClass('layui-nav-itemed')){
                menuBase.addClass('layui-nav-itemed')
            }
            $(item).addClass('layui-this')
        }
    })
    window.open(url,'inner-page')
}
//关闭tabber的跳页逻辑
function handleCloseTab(e,id){
    e.stopPropagation()
    if(tabbarList.length == 1){
        layer.alert('最后一个窗口不可关闭',{
            icon:2,
            title:'提示'
        })
        return
    }
    tabbarList = tabbarList.map(item => {item.active =false; return item}).filter((item,index) => {
        if(item.id == id) {
            if (index == tabbarList.length - 1) {
                tabbarList[index - 1].active = true
                handleChangeMenu(tabbarList[index - 1].id, tabbarList[index - 1].url)
                console.log( tabbarList[index - 1])
            } else {
                tabbarList[index + 1].active = true
                handleChangeMenu(tabbarList[index + 1].id, tabbarList[index + 1].url)
                console.log(tabbarList[index + 1])
            }
            return false
        }else{
            return true
        }
    })
    renderTabbar()
}