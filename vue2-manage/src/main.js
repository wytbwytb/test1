import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store/'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'

// 设置反向代理，前端请求默认发送到 http://localhost:8443/
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/'
Vue.prototype.$axios = axios
Vue.config.productionTip = false;

Vue.use(ElementUI);

new Vue({
	el: '#app',
	router,
	store,
	template: '<App/>',
	components: { App }
})
