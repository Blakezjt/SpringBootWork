// expressform.js

Page({
  data: {
    weight:"1",
    units:"kg",
    userInfo:{},
  },
  // 方法代码分装实现重量加减
  // mySetWeight(increment){
  //   let weight = this.data.weight+1;
  //   if(weight<10 && weight<=0){
  //     weight+=increment;
  //  }
  //  this.setData({
  //    weight:weight
  //  })
  // },
  declineWeight(){
    let weight = this.data.weight;
    weight--;
    if(weight<=0){
        weight=1;
      }
    this.setData({
      weight:weight
    })

  },
  addWeight(){
    let weight = this.data.weight;
    if(weight<10){
       weight++;
    }
    this.setData({
      weight:weight
    })

  },
  toAddress(){
    wx.reLaunch({
      url: '/pages/address/address',
    });
  },
  backMain(){
    var pages = getCurrentPages();
    if (pages.length > 1) {
      wx.navigateBack();
    } else {
      wx.reLaunch({
        url: '/pages/main2/main2',// 跳转到指定的页面
      });
    }
  }
  
  ,
  onLoad(options){
    // // 获取到app
    // let app = getApp();
    // // 获得公共变量
    // console.log(app.globalData.userInfo)
    // this.setData({
    //   userInfo:app.globalData.userInfo,
    // })
  },
  onShow(){
    let app = getApp();
    // 获得公共变量
    console.log(app.globalData.userInfo)
    this.setData({
      userInfo:app.globalData.userInfo,
    })
  }
  
})
