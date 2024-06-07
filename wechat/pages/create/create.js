
 Page({
   data: {
     username:'',
     password: '',
     confirmPassword:'',
     passwordStrength: ''
   },
   onAccountInput(event){
    this.setData({
      username:event.detail.value
    });
   },
   onPasswordInput(e) {
    const password = e.detail.value;
    let strength = 0;
    
    if (password.length >= 6 && password.length <= 16) {
      strength++;
    }
    if (/[a-zA-Z]/.test(password)) {
      strength++;
    }
    if (/\d/.test(password)) {
      strength++;
    }
    if (/\W/.test(password)) {
      strength++;
    }

    let passwordStrength = '';

    if (strength === 1) {
      passwordStrength = '弱';
    } else if (strength === 2) {
      passwordStrength = '中';
    } else if (strength >= 3) {
      passwordStrength = '强';
    }

    this.setData({
      password: password,
      passwordStrength: passwordStrength
    });
  },
   confirmPassword(event){
    this.setData({
      confirmPassword :event.detail.value
    });
  },

  goTomainAddress() {
    const { username, password, confirmPassword } = this.data;
    console.log("接受到的",username);
    console.log("接受到的",password);
    console.log("接受到的",confirmPassword);
    if (!username|| !password || !confirmPassword) {
      wx.showToast({
        title: '请填写完整的注册信息',
        icon: 'none'
      });
    };
    if (password !== confirmPassword) {
      wx.showToast({
        title: '两次输入的密码不一致',
        icon: 'none'
      });
      
      return;
    }
    if(password === confirmPassword){
            wx.showToast({
        title: '注册成功',
        icon: 'none',
      })
      wx.navigateTo({
        url: '/pages/login/login',
      })
      return;
    }
   
  

    

    // 调用后端接口进行账号注册等操作，并处理成功/失败的情况
    // ...
  },
    goToLogin: function () {
    wx.navigateTo({
      url: "/pages/login/login",
    });
  }
 })


