import axios from "axios"
import qs from "qs";
import store from "element-ui/packages/cascader-panel/src/store";
import util from "@/libs/util";

const userDB = [
  { username: 'admin', password: 'admin', uuid: 'admin-uuid', name: 'Admin' },
  { username: 'editor', password: 'editor', uuid: 'editor-uuid', name: 'Editor' },
  { username: 'user1', password: 'user1', uuid: 'user1-uuid', name: 'User1' }
]

export default [
  {
    path: '/api/login',
    method: 'post',
    async  handle ({ body }) {
      await axios.post('accounts/actions/check',qs.stringify({accountName:body.username,accountPassword:body.password}))
        .then((response) => {
          if(response.data.data.user.id){
            // localStorage.setItem("Flag", "isLogin");
            // localStorage.setItem("name",response.data.data.user.accountName)
            // localStorage.setItem("password",response.data.data.user.accountPassword)
            // localStorage.setItem("token",response.data.data.token)
            // this.$store.state.user.commit('updateInfo',"fff")
            util.cookies.set('name',response.data.data.user.accountName)
            util.cookies.set('password',response.data.data.user.accountPassword)
            util.cookies.set('uuid', response.data.data.user.accountName)
            util.cookies.set('token', response.data.data.token)
            // this.$router.push('/blog');
            return {
              code: 0,
              msg: '登录成功',
              data: {
                username: util.cookies.get('uuid'), password: util.cookies.get('password'), uuid: util.cookies.get('uuid'), name: util.cookies.get('name'),
                // username: data.user.accountName, password: data.user.accountPassword, uuid: data.user.accountName, name: data.user.accountName ,
                token: util.cookies.get('token')
              }
            }

          }else {
            util.cookies.remove('name')
            util.cookies.remove('password')
            util.cookies.remove('uuid')
            util.cookies.remove('token')
            return {
              code: 401,
              msg: '用户名或密码错误',
              data: {}
            }
          }


        }).catch((error)=>{
      });


   //   const user = userDB.find(e => e.username === body.username && e.password === body.password)
      var data = util.cookies.get('uuid');
      return {
        code: 0,
        msg: '登录成功',
        data: {
          username: util.cookies.get('uuid'), password: util.cookies.get('password'), uuid: util.cookies.get('uuid'), name: util.cookies.get('name'),
          // username: data.user.accountName, password: data.user.accountPassword, uuid: data.user.accountName, name: data.user.accountName ,
          token: util.cookies.get('token')
        }
      }

    }
  }
]
