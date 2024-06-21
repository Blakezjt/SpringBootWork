// pages/HealthCheck-in/HealthCheck-in.js

Page({

    /**
     * 页面的初始数据
     */
    data: {
      region:[],
      date:'2021-01-01',
      radio: '1',
    },
//今日体温
    onChange(event) {
      this.setData({
        radio: event.detail,
      });
    },
    onClick(event) {
      const { name } = event.currentTarget.dataset;
      this.setData({
        radio: name,
      });
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

    
//省市选择器
    getUserProvince:function(e)
     {    console.log('picker发送选择改变，携带值为', e.detail.value)
        this.setData({
            region:e.detail.value     //将用户选择的省市区赋值给region
            
        })
     },
//日期选择器
     bindDateChange: function(e) {
      console.log('picker发送选择改变，携带值为', e.detail.value)
      this.setData({
        date: e.detail.value
      })
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