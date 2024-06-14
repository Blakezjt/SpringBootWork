// pages/addressForm/addressForm.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        region: ['广东省', '广州市', '海珠区'],
        userName: "",
        tel: "",
        address: "",
        radioValue:"",
        switchValue:false
        
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
        let app = getApp();
        let sendTo = app.globalData.sendTo;
        if(sendTo != null){
            this.setData({
                userName:sendTo.userName,
                tel:sendTo.tel,
                address:sendTo.address,
        })
        }
        
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
    bindRegionChange: function (e) {
        console.log('picker发送选择改变，携带值为', e.detail.value)
        this.setData({
            region: e.detail.value
        })
    },
    //设置标签
    radioSelect(e){
        this.setData({
            radioValue:e.detail.value
        })
    },
    //提交表单
    confirmBtn(e) {
        this.setData({
            userName:e.detail.value.userName,
            tel:e.detail.value.tel,
            address:e.detail.value.address,
        })
        let app = getApp();
        app.globalData.sendTo = this.data;
        console.log(app.globalData.sendTo);
        wx.navigateBack();
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