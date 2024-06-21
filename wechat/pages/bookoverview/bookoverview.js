// pages/bookoverview/bookoverview.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
      books:[
        {
          bookid:1,
          title:'java企业级',
          author:'卓俊涛',
          quantity:'10'
        },
        {
          bookid:2,
          title:'java',
          author:'卓俊涛',
          quantity:'10'
        },
        {
          bookid:3,
          title:'企业级',
          author:'卓俊涛',
          quantity:'10'
        },
        {
          bookid:4,
          title:'java企业',
          author:'卓俊涛',
          quantity:'10'
        }
      ]
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
    onClickLeft() {
      wx.showToast({ title: '点击返回', icon: 'none' });
    },
    onClickRight() {
      wx.showToast({ title: '点击按钮', icon: 'none' });
    },
    onChange(e) {
      this.setData({
        value: e.detail,
      });
    },
    onSearch() {
      Toast('搜索' + this.data.value);
    },
    onClick() {
      Toast('搜索' + this.data.value);
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