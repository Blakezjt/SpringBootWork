// pages/expressCheck/expressCheck.js
var billnumber = [
    {billNumber:"SF1627255000256"},
    {billNumber:"SF1627879831746"},
    {billNumber:"SF162725145687"},
]
/*登陆功能数据判断函数*/
function check(billNumber){
    for (var i = 0; i < billnumber.length; i++) {
        if (billnumber[i].billNumber==billNumber) {
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
        billNumber : "",
    },
    checkInput(e){
        this.setData({
            billNumber : e.detail.value
        })
    },
    checkChange: function(e){
        var billnumber = this.data.billNumber;
        if(check(billnumber)){
            wx.navigateTo({
                url: '/pages/waybillForm/waybillForm',
              })
        }else{
            wx.showToast({
              title: '查询不到此单号',
            })
            this.setData({
                billNumber : ""
            })
        }
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