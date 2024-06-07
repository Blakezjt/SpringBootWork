Page({

  /**
   * 页面的初始数据
   */
  data: {
    indicatorDots: true,
    comsumer: 1,
    number: 2,
    dataList: [
      {
        id:1,
        orderTel: 234234234,
        orderTime: "2023/10/18 22:10",
        userName: "张机器",
        receiver: "李有才",
        fromAddress: "蚌埠市",
        toAddress: "芜湖市",
      },
      {
        id:2,
        orderTel: 465465142,
        orderTime: "2023/10/20 10:20",
        userName: "张三丰",
        receiver: "李思思",
        fromAddress: "晋江市",
        toAddress: "漳州市",
      }

    ]

  },
  changeIndicatorDots: function (e) {
    this.setData({
      indicatorDots: !this.data.indicatorDots
    })
  },
  setList() {
    wx.reLaunch({
      url: '/pages/expressform/expressform',
    })
  },
  deleteList(e) {
      const index = e.detail.index;  
      const dataList = this.data.dataList;  
      dataList.splice(index, 1); // 从dataList中删除数据  
      this.setData({ dataList }); // 更新dataList数组  

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