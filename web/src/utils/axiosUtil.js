//定制请求的实列

//导入axios
import axios from "axios";
//定义一个变量,记录公共的前缀，baseURL
import { ElMessage } from 'element-plus'
const baseURL = '/api';
const instance = axios.create({baseURL})
//添加请求拦截器
import { useTokenStore } from '../stores/token.js'
instance.interceptors.request.use(
    (config)=>{
        //请求前的回调
        //添加token
        const tokenStore = useTokenStore();
        if(tokenStore.token){
            config.headers.Authorization = tokenStore.token
        }
        return config;
    },
    (err)=>{
        Promise.reject(err)
    }
)
import router from '@/route/router.js'
//添加响应拦截器
instance.interceptors.response.use(
    result=>{
        if(result.data.code === 200){
            return result.data;
        }else{
            // alert(result.data.msg ? result.data.msg:'服务异常');
            ElMessage.error(result.data.msg ? result.data.msg:'服务异常')
            return Promise.reject(result.data);
        }
    },
    err=>{
        //判断响应状态码，如果为401，否则未登录，提示请登录，并跳转到登录页面
        if(err.response.status==401){
            ElMessage.error('请先登录')
            router.push('/login')
        }else{
            ElMessage.error('服务异常')
        }
        return Promise.reject(err);//异步的状态转化成失败的状态
    }
)

export default instance