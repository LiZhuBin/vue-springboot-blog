// 菜单 顶栏
export default [
  { path: '/blog', title: '首页', icon: 'home' },
  {
    title: '博客管理',
    icon: 'folder-o',
    children: [
      { path: '/blog/manage/blog-manage', title: '博客管理' },
      { path: '/blog/manage/write-article', title: '写博客' },
      { path: '/blog/manage/resources-manage', title: '资源管理' },
      { path: '/blog/manage/info-manage', title: '个人信息管理' }
    ]
  },
  {
    title: '开发者',
    icon: 'folder-o',
    children: [
      { path: '/developer/admin-mongo', title: 'admin' },
      { path: '/developer/druid', title: 'druid' },
      { path: '/developer/rabbitmq', title: 'rabbitmq' }
    ]
  },

]
