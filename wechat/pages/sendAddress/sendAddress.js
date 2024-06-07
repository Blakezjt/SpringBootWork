// pages/address/address.js
function defaultAddress(_value){
    if(_value!='r1') return true;
    else
        return false
}
Page({

    /**
     * 页面的初始数据
     */
    data: {
        myregion:['福建省','福州市','鼓楼区'],
        transportIndex: 0,
        consignee: "",
        mobile: "",
        detailAddress: "",
        defaultAddress :""
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
    bindRegionChange:function (e) {
    //   console.log(e)  
      this.setData({
          myregion:e.detail.value   //重新赋值给myregion
      })
    },
    bindDefault:function(e){
        this.setData({
            defaultAddress: e.detail.value
        })
    },
    bindKeyInput :function (e) {
        let id = e.target.id
        if(id=="consignee"){
            this.setData({consignee :e.detail.value})
        }
        if(id=="mobile"){
            this.setData({mobile :e.detail.value})
        }
        if(id=="detailAddress"){
            this.setData({detailAddress :e.detail.value})
        }
    },
    saveAddress:function(e){
        var consignee = e.detail.value.consignee;
        var mobile = e.detail.value.mobile;
        var detailAddress = e.detail.value.detailAddress;
        var _value = this.data.defaultAddress;
        if(consignee==''){
            wx.showToast({
              title: '请输入姓名',
            })
            return
        }
        else if(mobile==''){
            wx.showToast({
              title: '请输入手机号',
            })
            return
        }
        else if(mobile.length!=11){
            wx.showToast({
                title: '手机号格式错误',
              })
              return
        }
        else if(detailAddress==''){
            wx.showToast({
              title: '请输入详细地址',
            })
            return
        }
        else if(defaultAddress(_value)){
            wx.showToast({
              title: '请勾选默认地址',
            })
            return
        }
        else{
            let app = getApp();
            app.globalData.userInfo = this.data;
            let pages = getCurrentPages();
            let pervPage = pages[pages.length-2];
            let delta = pages.length-pervPage.index-1;
            wx.navigateBack({
                delta : delta,
                success:function () {
                    pervPage.onLoad();
                }
            })
        }
    },
    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide() {

    },
/**
     * 生命周期函数--监听页面加载
     */

    onLoad:function(options) { 
        let app = getApp();
        let userInfo = app.globalData.userInfo
        if(userInfo !=null){
        this.setData({
            consignee : userInfo.consignee,
            mobile : userInfo.mobile,
            detailAddress : userInfo.detailAddress,
            myregion : userInfo.myregion
        })
    }
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