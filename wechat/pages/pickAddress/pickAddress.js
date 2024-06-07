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
        transportValues:["收货时间不限", "周六日/节假日收货", "周一至周五收货"],
        transportIndex: 0,
        _consignee: "",
        _mobile: "",
        _detailAddress: "",
        defaultAddress :""
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
    bindTransportDayChange:function (e) {
        // console.log('picker country 发生选择改变，携带值为', e.detail.value);
        this.setData({
            transportIndex: e.detail.value
        })
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
    bindKeyInput2 :function (e) {
        let id = e.target.id
        if(id=="_consignee"){
            this.setData({_consignee :e.detail.value})
        }
        if(id=="_mobile"){
            this.setData({_mobile :e.detail.value})
        }
        if(id=="_detailAddress"){
            this.setData({_detailAddress :e.detail.value})
        }
    },
    saveAddress:function(e){
        var _consignee = e.detail.value._consignee;
        var _mobile = e.detail.value._mobile;
        var _detailAddress = e.detail.value._detailAddress;
        var _value = this.data.defaultAddress;
        if(_consignee==''){
            wx.showToast({
              title: '请输入姓名',
            })
            return
        }
        else if(_mobile==''){
            wx.showToast({
              title: '请输入手机号',
            })
            return
        }
        else if(_mobile.length!=11){
            wx.showToast({
                title: '手机号格式错误',
              })
              return
        }
        else if(_detailAddress==''){
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
            app.globalData.userInfo2 = this.data;
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
        let userInfo2 = app.globalData.userInfo2
        if(userInfo2 != null){
            this.setData({
                _consignee : userInfo2._consignee,
                _mobile : userInfo2._mobile,
                _detailAddress : userInfo2._detailAddress,
                myregion : userInfo2.myregion
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