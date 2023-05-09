
<template>
  <div>

    <Form ref="form" :model="formData" :rules="rules" :label-width="80">
      <input type="hidden" v-model="formData.uid"/>

      <Row>
        <Col span="12">
          <FormItem label="登录名称">
            <Input v-model="formData.username" placeholder="登录名称"></Input>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="真实姓名" prop="name">
            <Input v-model="formData.name" placeholder="真实姓名"></Input>
          </FormItem>
        </Col>
      </Row>

      <Row>
        <Col span="12">
          <FormItem label="生日">
            <DatePicker type="date" :value="formData.birthday" @on-change="setBirthday" format="yyyy-MM-dd" placeholder="生日" style="width: 100%"></DatePicker>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="电话">
            <Input v-model="formData.telephone" placeholder="电话"></Input>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="12">
          <FormItem label="邮箱">
            <Input v-model="formData.email" placeholder="邮箱"></Input>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="部门">
              <Select v-model="formData.deptId" >
                <Option v-for="item in deptList" :value="item.id" :key="item.id">{{ item.name }}</Option>
              </Select>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="24">
          <FormItem>
            <Button type="primary" @click="handleSubmit('form')">保存</Button>
            <Button @click="go2('userList')" style="margin-left: 8px">关闭</Button>
          </FormItem>
        </Col>
      </Row>
    </Form>
  </div>
</template>

<script>
    import axios from 'axios'
    import Qs from 'qs'

    const instance = axios.create({
      baseURL: 'http://localhost:8062/api/user',
      // baseURL: 'http://localhost:81/',
      timeout: 1000000
    })

    instance.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'

    const instance2 = axios.create({
      baseURL: 'http://localhost:8062/api/dept',
      // baseURL: 'http://localhost:81/',
      timeout: 1000000
    })

    instance2.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'

    export default {
        data () {
            return {
                deptList: [],
                formData: {
                    uid: '',
                    username: '',
                    name: '',
                    password: '',
                    password2: '',
                    birthday:'',
                    sex: '',
                    telephone: '',
                    email: ''
                },
                rules: {
                  name: [
                    {required: true, message: '请输入名称', trigger: 'blur'},
                    {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                  ]
                }
            }
        },
        methods: {
          setBirthday (v) {
            this.formData.birthday = v
          },
            // 提交
            handleSubmit (formName) {

              this.$refs[formName].validate((valid) => {
                if (valid) {
                  instance.post('/admin/user/save', Qs.stringify(this.formData, {arrayFormat: 'repeat'})).then(() => {
                    // this.$message(response.data.msg);
                    this.go2("userList")
                  })

                } else {
                  console.log('error submit!!');
                  return false;
                }
              });



            },
            // 根据ID查询
            get (id) {
                instance.get('/admin/user/edit/' + id).then(response => {
                  this.formData = response.data
                }).catch(error => {
                    console.log(error)
                })
            },

            go2 (name) {
                this.$router.push({ name: name })
            }
        },
        created () {
            let id = this.$route.query.id;
            if (id) {
                this.get(id)
            }

          //查询部门列表
          instance2.post('/admin/dept/list').then(response => {
            this.deptList = response.data
          }).catch(error => {
            console.log(error)
          })
        }

    }
</script>
