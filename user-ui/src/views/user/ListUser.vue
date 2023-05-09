<template>
    <div>
        <div>

          <Form ref="formData" :model="formData">
            <Row :gutter="16">
              <Col span="6">
                <FormItem label="登录名称">
                  <Input v-model="formData.username" placeholder="登录名称"></Input>
                </FormItem>
              </Col>
              <Col span="6">
                <FormItem label="真实姓名">
                  <Input v-model="formData.name" placeholder="真实姓名"></Input>
                </FormItem>
              </Col>
              <Col span="6">
                <FormItem label="部门">
                  <Select v-model="formData.deptId" clearable  >
                    <Option v-for="item in deptList" :value="item.id" :key="item.id">{{ item.name }}</Option>
                  </Select>
                </FormItem>
              </Col>
              <Col span="6">
                <Button type="primary" @click="add">添加</Button>
                <Button type="primary" @click="query">查询</Button>
              </Col>
            </Row>
          </Form>

        </div>

        <div>

          <Table :columns="columns7" :data="rows" style="width: 100%"></Table>

        </div>

        <div class="paging">

          <Page :total="total" show-total show-elevator show-sizer @on-change="changePage" @on-page-size-change="changePageSize" />

        </div>
    </div>
</template>
<style scoped>
    .paging {
        float: right;
        margin-top: 10px;
    }
</style>

<script>
    import axios from 'axios'
    import Qs from 'qs'

    const instance = axios.create({
      baseURL: 'http://localhost:8062/api/user',
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
              columns7: [
                {
                  title: '用户名称',
                  key: 'username'
                },
                {
                  title: '真实姓名',
                  key: 'name'
                },
                {
                  title: 'Action',
                  key: 'action',
                  width: 150,
                  align: 'center',
                  render: (h, params) => {
                    return h('div', [
                      h('Button', {
                        props: {
                          type: 'primary',
                          size: 'small'
                        },
                        style: {
                          marginRight: '5px'
                        },
                        on: {
                          click: () => {
                            this.edit(params.row.uid)
                          }
                        }
                      }, 'View'),
                      h('Button', {
                        props: {
                          type: 'error',
                          size: 'small'
                        },
                        on: {
                          click: () => {
                            this.remove(params.row.uid)
                          }
                        }
                      }, 'Delete')
                    ]);
                  }
                }
              ],

                formData: {
                    username: '',
                    name: '',
                    deptId: ''
                },
                // 初始化信息总条数
                total: 0,
                // 每页显示多少条
                pageSize: 10,
                // 显示的数据
                rows: [],
                deptList: []
            }
        },
        methods: {
            // 添加
            add () {
                this.$router.push({
                    name: 'userEdit'
                })
            },
            // 删除
            remove (id) {
              this.$Modal.confirm({
                title: '确认删除',
                content: '确定要删除吗？',
                onOk: () => {
                  instance.get(`/admin/user/delete/` + id).then(() => {
                    this.$Message.info('删除成功')
                    this.query()
                  }).catch(error => {
                    console.log(error)
                  })
                }
              })
            },
            // 修改
            edit (id) {
                this.$router.push({
                    name: 'userEdit',
                    query: {id: id}
                })
            },
            // 查询
            query () {
                instance.post('/admin/user/page', Qs.stringify(this.formData)).then(response => {
                    this.rows = response.data.list
                    this.total = response.data.total
                }).catch(error => {
                    console.log(error)
                })
            },
            // 分页
            changePage (index) {
                this.formData.page = index
                this.query()
            },
            // 设置每页行数
            changePageSize (size) {
                this.formData.page = 1
                this.formData.rows = size
                this.query()
            }
        },
        created () {
            this.query();

            //查询部门列表
            instance2.post('/admin/dept/list').then(response => {
              this.deptList = response.data
            }).catch(error => {
              console.log(error)
            })

        }

    }
</script>

