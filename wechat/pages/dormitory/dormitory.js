// pages/vacation/vacation.js
Page({
  onClickLeft() {
    wx.showToast({ title: '点击返回', icon: 'none' });
  },
  onClickRight() {
    wx.showToast({ title: '点击按钮', icon: 'none' });
  },
  onClickSuccess(){
    wx.showToast({
      title: '提交成功',
      icon: 'success',
      duration: 2000//持续的时间
    })
  },
    /**
     * 页面的初始数据
     */
    data: {
      steps: [
        {
          text: '提交申请',
        },
        {
          text: '辅导员审批',
        },
        {
          text: '系主任审批',
        },
        {
          text: '请假完成',
        },
      ],
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