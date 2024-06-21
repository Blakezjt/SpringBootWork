// pages/schooltimetable/schooltimetable.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
      onLoad: function() {  
        // 从全局变量中获取数据  
        let data = getApp().globalData.result;  
        // 使用数据...  
      }  ,
        active: 1,
        CourseName:"Java企业级",
        teacherid:"卓俊涛",
        classnameid:"化工316",
        time:"8:00-10:00",
        date:"周一",
        number:{
          array1:[],
          array2:[],
          array3:[],
          array4:[],
          array5:[],
          array6:[],
        },
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

    onChange(event) {
      wx.showToast({
        title: `切换到课表 ${event.detail.name+1}`,
        icon: 'none',
      });
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