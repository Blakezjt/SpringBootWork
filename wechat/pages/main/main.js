// pages/main/main.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    background: [ 'lun1.png','lun2.png', 'lun3.png'],
    indicatorDots: true,
    vertical: false,
    autoplay: true,
    circular: false,
    interval: 2000,
    duration: 500,
    previousMargin: 0,
    nextMargin: 0,
    functionInfo:[
        {
            id:"course",
            name:'课程学术 ',
            detail:'课程表、选课、成绩、考试'
        },
        {
            id:"administration",
            name:'行政服务 ',
            detail:'请假、宿舍、办证'
        },
        {
            id:"2",
            name:'财务后勤 ',
            detail:'缴费、查询、后勤'
        },
        {
            id:"2",
            name:'图书服务 ',
            detail:'检索、借阅、资源'
        },
        {
            id:"social",
            name:'校园社交 ',
            detail:'活动、社团、论坛'
        },
        {
            id:"2",
            name:'健康安全 ',
            detail:'检索、借阅、资源'
        }
    ],
    newsInfo:[
        '福州大学至诚学院校园网使用说明',
        '关于防钓鱼邮件的网络安全提示',
        '新生线上迎新系统操作指南',
        '实行扫码入校的通知',
        'APP使用须知',
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
  onClickSelect(e){
    let item = e.currentTarget.dataset.item
    console.log('pages/courseModel/'+item.id);
    wx.navigateTo({
      url: "/pages/"+item.id+"/"+item.id,
    })
    // wx.showModal({
    //   title: '暂无'+item.id,
    //   content: '',
    //   complete: (res) => {
    //     if (res.cancel) {
          
    //     }
    
    //     if (res.confirm) {
          
    //     }
    //   }
    // })
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