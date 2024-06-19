// pages/mail/mail.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        isChangeShipping: true, //切换上门取件和服务点自寄
        isAgree: true, //是否同意条款
        show: false, //是否跳出物品信息弹窗
        time: false, //是否跳出时间信息弹窗
        weight: 1, //寄件重量
        //寄件类型
        productType: ['日用品', '食品', '文件', '衣物', '数码产品', '药品', '生鲜', '易碎品', '其他'],
        //初始化寄件类型
        productItem: '日用品',
        //给快递员备注选项
        courierRemark: [{
            remarkName: '带包装袋',
            isRemark: false
        }, {
            remarkName: '带胶带',
            isRemark: false
        }, {
            remarkName: '不要打电话',
            isRemark: false
        }, {
            remarkName: '上门时安静',
            isRemark: false
        }, {
            remarkName: '放在家门口',
            isRemark: false
        }, {
            remarkName: '放在水表箱',
            isRemark: false
        }, ],
        // 给快递员备注的内容
        remark: [],
        // 给快递员备注是否成功
        isRemackSuccess: false,
        dateTine: ['今天', '明天', '后天'],
        timeDetail: [{
                startTime: 9,
                endTime: 11,
                isShow: false,
                isPastDue: false
            },
            {
                startTime: 11,
                endTime: 13,
                isShow: false,
                isPastDue: false,
            },
            {
                startTime: 13,
                endTime: 15,
                isShow: false,
                isPastDue: false,
            },
            {
                startTime: 15,
                endTime: 17,
                isShow: false,
                isPastDue: false,
            },
            {
                startTime: 17,
                endTime: 19,
                isShow: false,
                isPastDue: false,
            },
        ],
        // 默认date
        defautTime: '今天',
        nowTime: {
            startTime: 0,
            endTime: 0,
        },
        // 当前dateTine的index
        getIndex: 0,
        // 当前时间的index
        timeIndex: -1,
        // 记录是否是今天时间已经结束(-1表示是,0表示否)
        recordDate: 0,
        // 服务点自寄
        servicePoint:"请先选择寄件地址,方便为您推荐站点",
        // 填写收寄地址后看预估运费
        freight:"填写收寄地址后看预估运费"
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
        let app = getApp();
        this.setData({
            userInfo: app.globalData.userInfo,
            sendTo: app.globalData.sendTo,
        })
        this.getTimeDetail();
        console.log(this.data.getIndex);
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
        let app = getApp();
        this.setData({
            userInfo: app.globalData.userInfo,
            sendTo: app.globalData.sendTo,
        })
        if (app.globalData.userInfo!=null) {
            this.setData({
                servicePoint:'请选择服务点'
            })
            if (app.globalData.sendTo!=null) {
            this.setData({
                freight:'￥10.00'
            })
            }
        }
        
    },
    /**
     * 上门取件
     */
    onClickShipping() {
        this.setData({
            isChangeShipping: true,
        })
    },
    /**
     * 切换上门取件和服务点自寄
     */
    onClickShipping1() {
        this.setData({
            isChangeShipping: false
        })
    },
    // 请选泽服务点
    onservicePoint(){
        wx.showModal({
          title: '暂无服务点',
          content: '',
          complete: (res) => {
            if (res.cancel) {
              
            }
        
            if (res.confirm) {
              
            }
          }
        })
    },
    /**
     * 切换是否同意条款
     */
    onClickAgree() {
        let isAgree = this.data.isAgree;
        this.setData({
            isAgree: !isAgree
        })
    },
    //下单
    placeOrder(){
        if (!this.data.isAgree) {
            let app = getApp();
            let list = {};
            list.userInfo = app.globalData.userInfo;//寄出地址
            list.sendTo = app.globalData.sendTo;//收货地址
            list.weight = this.data.weight;//重量
            list.productItem = this.data.productItem;//物品类型
            list.remark = this.data.remark;//快递员备注
            list.defautTime = this.data.defautTime;//上门时间（今天，明天，后天）
            list.nowTime = this.data.nowTime//上门具体时间
            
            if(app.globalData.userInfo==null){
                wx.showModal({
                  title: '请先选择寄出地址',
                  content: '',
                })
            }
            else if (app.globalData.sendTo==null) {
                wx.showModal({
                    title: '请先选择寄到地址',
                    content: '',
                  })
            }
            else{
                console.log(list);
                // wx.request({
                //     url:"/login",  //会与js中的url进行拼接
                //     method:"POST",
                //     data: {
                //       list:list
                //     },
                //   }).then(res=>{
                //     wx.showToast({
                //       title: '下单成功',
                //     })
                //   })
            }
        }
        else{
            wx.showModal({
              title: '请先勾选阅读并同意《服务条款》和《证照信息》',
              content: '',
              complete: (res) => {
                if (res.cancel) {
                  
                }
            
                if (res.confirm) {
                  
                }
              }
            })
        }
    },
    /**
     * 跳转寄出地址界面
     */
    onSendOf() {
        wx.navigateTo({
            url: '/pages/sendOf/senfOf',
        })
    },
    onSendTo() {
        wx.navigateTo({
            url: '/pages/sendTO/sendTo',
        })
    },
    selectTime() {
        let time = this.data.time;
        this.setData({
            time: !time
        })
        console.log(this.data.nowTime);
    },
    getTimeDetail() {
        let currentTime = new Date().getHours() + 2;
        let startT = "nowTime.startTime";
        let endT = "nowTime.endTime";
        let flag = 0;
        this.data.timeDetail.forEach((value, index) => {
            let istime = "timeDetail[" + index + "].isShow";
            let isPastDue = "timeDetail[" + index + "].isPastDue";
            if (value.startTime <= currentTime && currentTime < value.endTime) {
                flag = 1;
                this.setData({
                    [istime]: true,
                    [startT]: value.startTime,
                    [endT]: value.endTime,
                    timeIndex: index
                })
            } else {
                if (flag == 0) {
                    this.setData({
                        [isPastDue]: true
                    })
                }

            }
        });
        if (this.data.timeIndex == -1) {
            this.setData({
                getIndex: 1,
                timeIndex: 0,
                recordDate: this.data.timeIndex
            })
            let istimeIndex = "timeDetail[0].isShow";
            this.setData({
                defautTime: '明天',
                [istimeIndex]: true,
                [startT]: this.data.timeDetail[0].startTime,
                [endT]: this.data.timeDetail[0].endTime,
            })
            this.data.timeDetail.forEach((value, index) => {
                let isPastDue = "timeDetail[" + index + "].isPastDue";
                this.setData({
                    [isPastDue]: false
                })
            });
        }
    },
    /**
     * 
     */
    onShowProduct() {
        let show = this.data.show;
        this.setData({
            show: !show
        })
        if (this.data.remark.length > 0) {
            this.setData({
                isRemackSuccess: true,
            })
        }
    },
    onChange(event) {
        this.setData({
            weight: event.detail
        })
    },
    onClickSelect(e) {
        let index = e.currentTarget.dataset.index;
        let item = e.currentTarget.dataset.item;
        this.setData({
            currntIndex: index,
            productItem: item
        })
    },
    onRemack(e) {
        let itemRemack = e.currentTarget.dataset.item;
        let index = e.currentTarget.dataset.index;
        let remack = this.data.remark;
        let remackfilter = "remark";
        remack.push(itemRemack);
        let filteredArr = remack.filter((item, index, self) => {
            return self.indexOf(item) === index;
        });
        let isRemack = "courierRemark[" + index + "].isRemark";
        this.setData({
            [isRemack]: !this.data.courierRemark[index].isRemark
        })
        if (!this.data.courierRemark[index].isRemark) {
            let removedArr = filteredArr.filter(item => item !== itemRemack);
            this.setData({
                [remackfilter]: removedArr
            })
        }
    },
    // 改变上门时间（今天，明天，后天）
    onChangeTime(e) {
        let index = e.currentTarget.dataset.index;
        let timeIndex = this.data.timeIndex;
        let istimeIdenx = "timeDetail[" + timeIndex + "].isShow";
        this.setData({
            getIndex: index,
            [istimeIdenx]: false
        })
        console.log(this.data.getIndex);
        if (index == 0) {
            this.getTimeDetail();
        }
        // if (index == 1 && this.data.recordDate == -1) {
        //     let istimeIndex = "timeDetail[0].isShow";
        //     this.setData({
        //         [istimeIndex]: true,
        //     })
        // }
        if (index == 1 || index == 2) {
            this.data.timeDetail.forEach((value, index) => {
                let isPastDue = "timeDetail[" + index + "].isPastDue";
                this.setData({
                    [isPastDue]: false
                })
            });
        }
        if (index==2) {
            
        }
    },
    setTimeVisit(e) {
        let index = e.currentTarget.dataset.index;
        let isPastDue = this.data.timeDetail[index].isPastDue;
        let timeSta = this.data.timeDetail[index].startTime;
        let timeEnd = this.data.timeDetail[index].endTime;
        let getIndex = this.data.getIndex;
        let dateT = this.data.dateTine[getIndex];
        let timeIndex = this.data.timeIndex; //当前选中时间的index
        if (!isPastDue) {
            let istimeIdenx = "timeDetail[" + timeIndex + "].isShow";
            this.setData({
                [istimeIdenx]: false
            })
            let istime = "timeDetail[" + index + "].isShow";
            let startT = "nowTime.startTime";
            let endT = "nowTime.endTime";
            this.setData({
                defautTime: dateT,
                [startT]: timeSta,
                [endT]: timeEnd,
                [istime]: true,
                timeIndex: index
            })
            this.selectTime();
        }
        // if (getIndex==1&&timeIndex == 1 && this.data.recordDate == -1) {
        //         let istimeIndex = "timeDetail[0].isShow";
        //         this.setData({
        //             [istimeIndex]: true,
        //             recordDate:0
        //         })
        //     }
    },
    // 优惠券
    onDiscountCoupon(){
        wx.showModal({
          title: '暂无优惠券',
          content: '',
          complete: (res) => {
            if (res.cancel) {
              
            }
        
            if (res.confirm) {
              
            }
          }
        })
    },
    onValueAdded(){
        wx.showModal({
          title: '暂无增值服务',
          content: '',
          complete: (res) => {
            if (res.cancel) {
              
            }
        
            if (res.confirm) {
              
            }
          }
        })
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