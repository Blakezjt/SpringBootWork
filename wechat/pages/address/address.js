// expressform.js

Page({
  data: {
    userName: "",
    tel: "",
    address: "",
    serverName: "",
    serverTel: "",
    serverAddress: "",
    region: ['广东省', '广州市', '海珠区'],
    receiverRegion: ['福建省', '泉州市', '泉港区'],
    customItem: '全部'
  },
  bindRegionChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      region: e.detail.value
    })
  },
  bindKeyInput: function (e) {
    // e携带的信息非常多
    let id = e.target.id;
    if (id == "userName") {
      this.setData({
        userName: e.detail.value
      })
    }
    else if(id == "tel"){
      this.setData({
        tel: e.detail.value
      })
    }
    else if(id == "address"){
      this.setData({
        address: e.detail.value
      })
    }
    else if(id == "serverName"){
      this.setData({
        serverName: e.detail.value
      })
    }
    else if(id == "serverTel"){
      this.setData({
        serverTel: e.detail.value
      })
    }
    else if(id == "serverAddress"){
      this.setData({
        serverAddress: e.detail.value
      })
    }

  },
  expressform() {
    console.log(this.data)
    // 获得app
    let app = getApp();
    // 获得公共变量
    app.globalData.userInfo = this.data;
    app.globalData.userInto = this.data;
    wx.reLaunch({
      url: '/pages/expressform/expressform',
    });
    wx.navigateBack()
  }


})