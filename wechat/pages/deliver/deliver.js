// pages/deliver/deliver.js
function itemRadio(itemValue){
    if(itemValue == "r1" || itemValue == "r2") return true;
    else return false;
}
function deliverRadio(deliverValue){
    if(deliverValue == "r1" || deliverValue == "r2" || deliverValue == "r3") return true;
    else return false;
}
function payRadio(payValue){
    if(payValue == "r1" || payValue == "r2" || payValue == "r3") return true;
    else return false;
}
function praticRadio(praticValue){
    if(praticValue == "r1" || praticValue == "r2") return true;
    else return false;
}

Page({

    /**
     * 页面的初始数据
     */
    data: {
        itemRadioValue : "",
        deliverRadioValue : "",
        payRadioValue : "",
        praticRadioValue : "",
        kgData : 0, 
        disable : true,
    //    check : false,
        price : "--" ,
    }, 
    itemHandleChange(e){
        this.setData({itemRadioValue : e.detail.value})
    },
    deliverHandleChange(e){
        this.setData({deliverRadioValue : e.detail.value})
    },
    payHandleChange(e){
        this.setData({ payRadioValue : e.detail.value})
    },
    praticHandleChange(e){
        this.setData({ praticRadioValue : e.detail.value})
    },
    bindKg(e){
        this.setData({kgData : e.detail.value})
    },
    /**
     * 实现按钮下单
     */
    placeOrderChange:function(e){
        var itemValue = this.data.itemRadioValue;
        var deliverValue = this.data.deliverRadioValue;
        var payValue = this.data.payRadioValue;
        var praticValue = this.data.praticRadioValue;
        var price = this.data.price;
        let app = getApp();
        let userInfo = app.globalData.userInfo
        let userInfo2 = app.globalData.userInfo2
        if(userInfo==null){
            wx.showToast({
              title: '请输入寄件信息',
            })
        }
        else if(userInfo2==null){
            wx.showToast({
                title: '请输入收件信息',
              })
        }
        else if(itemRadio(itemValue)&&deliverRadio(deliverValue)
            &&payRadio(payValue)&&praticRadio(praticValue)&&price!="--"
            ){
            wx.showToast({
                title: '下单成功',
                icon: 'success',
                duration: 2000
              })
                wx.navigateTo({
                    url: '/pages/mainAddress/mainAddress',
                  })
        }else{
            wx.showToast({
                title: '下单失败',
              })
        }
        // this.setData({
        //     check : false,
        // })
    },
    /**
     * 预估重量功能
     * 加减按钮事件
     */
    handletap:function(e) {
        
        //e.currentTarget注册了事件的监听对象
        const operation = e.currentTarget.dataset.operation
        this.setData({
            //这是获取data-operation这个属性的{{1}}{{-1}}这些值的方法
            kgData : this.data.kgData += operation 
        })
        var data = this.data.kgData
        //如果重量小于1kg将不能再减
        if(data <= 1){
            this.setData({
                disable : true
            }) 
        }else{
            this.setData({
                disable : false
            })
        }
        if(data >=10){
            this.setData({
                add_disable : true
            })
        }else{
            this.setData({
                add_disable : false
            })
        }
        //预估价格随预估重量变化
        if(data == 1){
            this.setData({
                price : 17
            }) 
        }else{
            this.setData({
                price : 17 + data*3
            }) 
        }
    },
    //实现跳转到添加地址功能
    intoAddress1:function(e){
        wx.navigateTo({
          url: '/pages/sendAddress/sendAddress',
        })
    },
    intoAddress2:function(e){
        wx.navigateTo({
          url: '/pages/pickAddress/pickAddress',
        })
    },
    /**
     * 生命周期函数--监听页面加载
     */

        onLoad:function(options) { 
            let app = getApp();
            let userInfo2 = app.globalData.userInfo2
            let userInfo = app.globalData.userInfo
            if(userInfo != null){
                let mobileLen = userInfo.mobile.length
                let userInfo_mobile = userInfo.mobile.substring(0,3)+"****"+userInfo.mobile.substring(7,mobileLen)
                this.setData({
                    userInfo : app.globalData.userInfo,
                    userInfo_mobile: userInfo_mobile,
                    
                })
            }
            if(userInfo2 != null){
                let mobileLen2 = userInfo2._mobile.length
                let userInfo2_mobile = userInfo2._mobile.substring(0,3)+"****"+userInfo2._mobile.substring(7,mobileLen2)
                this.setData({
                    userInfo2 : app.globalData.userInfo2,
                    userInfo2_mobile: userInfo2_mobile,
                    
                })
            }

        },
        
    /**
     * 生命周期函数--监听页面卸载
     */
        onUnload() {

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