
import { mount } from '@vue/test-utils'
import UpdatePassword from '@/views/update-password.vue'
import Register from '@/views/register.vue'
import ElementUI from 'element-ui'
import Vue from 'vue'

Vue.use(ElementUI)

describe('UpdatePassword.vue', () => {
  let wrapper

  beforeEach(() => {
    wrapper = mount(UpdatePassword)
  })

  it('should validate original password', async () => {
    const form = wrapper.vm.ruleForm
    form.password = ''
    await wrapper.vm.$refs.ruleForm.validate()
    expect(wrapper.vm.$message.error).toHaveBeenCalledWith('密码不能为空')
  })

  it('should validate password match', async () => {
    const form = wrapper.vm.ruleForm
    form.password = 'oldpass'
    form.newpassword = 'newpass'
    form.repassword = 'different'
    await wrapper.vm.onUpdateHandler()
    expect(wrapper.vm.$message.error).toHaveBeenCalledWith('两次密码输入不一致')
  })
})

describe('Register.vue', () => {
  let wrapper

  beforeEach(() => {
    wrapper = mount(Register)
  })

  describe('Student Registration', () => {
    beforeEach(() => {
      wrapper.vm.tableName = 'xuesheng'
    })

    it('should validate required fields', async () => {
      const form = wrapper.vm.ruleForm
      form.xueshengzhanghao = ''
      form.mima = ''
      form.xueshengxingming = ''
      await wrapper.vm.login()
      expect(wrapper.vm.$message.error).toHaveBeenCalledWith('学生账号不能为空')
    })

    it('should validate phone format', async () => {
      const form = wrapper.vm.ruleForm
      form.xueshengdianhua = '123' // Invalid format
      await wrapper.vm.login()
      expect(wrapper.vm.$message.error).toHaveBeenCalledWith('学生电话应输入手机格式')
    })
  })

  describe('Teacher Registration', () => {
    beforeEach(() => {
      wrapper.vm.tableName = 'jiaogong'
    })

    it('should validate required fields', async () => {
      const form = wrapper.vm.ruleForm
      form.jiaogongzhanghao = ''
      form.mima = ''
      form.jiaogongxingming = ''
      await wrapper.vm.login()
      expect(wrapper.vm.$message.error).toHaveBeenCalledWith('教工账号不能为空')
    })

    it('should validate phone format', async () => {
      const form = wrapper.vm.ruleForm
      form.lianxidianhua = '123' // Invalid format
      await wrapper.vm.login()
      expect(wrapper.vm.$message.error).toHaveBeenCalledWith('联系电话应输入手机格式')
    })
  })

  describe('Department Registration', () => {
    beforeEach(() => {
      wrapper.vm.tableName = 'erjixueyuan'
    })

    it('should validate required fields', async () => {
      const form = wrapper.vm.ruleForm
      form.zhanghao = ''
      form.mima = ''
      form.xingming = ''
      await wrapper.vm.login()
      expect(wrapper.vm.$message.error).toHaveBeenCalledWith('账号不能为空')
    })

    it('should validate phone format', async () => {
      const form = wrapper.vm.ruleForm
      form.lianxifangshi = '123' // Invalid format
      await wrapper.vm.login()
      expect(wrapper.vm.$message.error).toHaveBeenCalledWith('联系方式应输入手机格式')
    })
  })

  it('should handle successful registration', async () => {
    const mockResponse = { data: { code: 0 } }
    wrapper.vm.$http.post = jest.fn().mockResolvedValue(mockResponse)
    
    await wrapper.vm.login()
    expect(wrapper.vm.$message).toHaveBeenCalledWith({
      message: '注册成功',
      type: 'success',
      duration: 1500
    })
  })

  it('should handle failed registration', async () => {
    const mockResponse = { data: { code: 1, msg: 'Registration failed' } }
    wrapper.vm.$http.post = jest.fn().mockResolvedValue(mockResponse)
    
    await wrapper.vm.login()
    expect(wrapper.vm.$message.error).toHaveBeenCalledWith('Registration failed')
  })
})
