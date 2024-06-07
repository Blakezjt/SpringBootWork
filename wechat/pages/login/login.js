// pages/login/login.js
/*登陆数据*/
var users = [
  {userName:"1",password:"1"},
  {userName:"123456",password:"123456"},
  {userName:"1234567j",password:"1234567j"},
]
/*登陆功能数据判断函数*/
function login(userName,password){
    for (var i = 0; i < users.length; i++) {
        if (users[i].userName === userName && users[i].password === password) {
          return true;
        }
      }
      return false;
}
Page({

    /**
     * 页面的初始数据
     */
    data: {
        inputUsername: "",
        inputPassword: "",
        login_txt:"用户/快递员登录",
        select:false,
        name:""
      },
      /**
       * 登录方式下拉框
       */
      bindShowMsg(){
        this.setData({
            select: !this.data.select
        })
      },
      mySelect(e){
        var name = e.currentTarget.dataset.name;
        this.setData({
            login_txt: name,
            select :false
        })
        this.setData({
            name : e.currentTarget.dataset.name
        })
      },
      /**
       * 登录功能
       */
      onAccountInput(e) {
        this.setData({ inputUsername: e.detail.value });
      },
      onPasswordInput(e) {
        this.setData({ inputPassword: e.detail.value });
      },
    changeLogin: function(e) {
        var userName = this.data.inputUsername;
        var password = this.data.inputPassword;
        var name = this.data.name;
      if(login(userName,password)){  
          if(name == '用户登录'){
            wx.reLaunch({
                url: '/pages/mainAddress/mainAddress',
            })
          }else if(name == '快递员登录'){
            wx.reLaunch({
                url: '/pages/main2/main2',
            })
          }else{
              wx.showToast({
                title: '请选择登录方式',
              })
          }
        this.setData({ 
            inputUsername: "",
            inputPassword: ""
        })
    }else{
        wx.showToast({
          title: '登录失败',
        })
        this.setData({ 
            inputUsername: "",
            inputPassword: ""
        })
      }
    },
    /** 
 * 跳转到注册页面
*/

changeLogin2:function() {
  wx.navigateTo({
    url: '/pages/create/create',
  })
},

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
      

    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady() {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow() {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide() {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh() {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom() {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage() {

    }
})