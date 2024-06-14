// pages/login/login.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        users: [{
            userName:'小明',
            account: "test123",
            password: "test123",
            tel:"18876262341",
        }, {
            userName:'小路',
            account: "t123",
            password: "t123",
            tel:"18998262341",
        }, {
            userName:'小溪',
            account: "111",
            password: "111",
            tel:"18009262341",
        }, {
            userName:'小发',
            account: "test",
            password: "test",
            tel:"18234262341",
        }],
        courier:[{
            account: "test123",
            password: "test123",
            tel:"18123262341",
        }],
        switchOver:true,
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
     * 用户登入
     */
    onLoginUser(e){
        this.onLoginType(e,this.data.users,'/pages/main/main');
    },
    /**
     * 快递员登入
     */
    onLoginCourier(e){
        this.onLoginType(e,this.data.courier,);
    },
    /**
     * 登入函数
     */
    onLoginType(e,loginType,url) {
         let account = e.detail.value.account;
        let password = e.detail.value.password;
        for (let User of loginType) {
            if (User.account == account && User.password == password) {
                wx.showToast({
                    title: '登入成功',
                    icon: 'success',
                    duration: 500,
                    success(res) {
                        setTimeout(function () {
                            wx.switchTab({
                                url: url,
                            })
                        },500)
                        let app = getApp();
                        app.globalData.userName = User.userName;
                        app.globalData.tel = User.tel
                    }
                })
                return;
            }
        }
        wx.showToast({
            icon: "error",
            title: '登入失败',
        })
    },
    /**
     * 
     */
    onRegister() {
        wx.navigateTo({
            url: '/pages/register/register',
        })
    },
    onSwitchOver(){
        this.setData({
            switchOver:true
        })
    },
    onSwitchOver1(){
        this.setData({
            switchOver:false
        })
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