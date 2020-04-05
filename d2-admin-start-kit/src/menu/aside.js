// 菜单 侧边栏
export default [
  { path: '/blog', title: '首页', icon: 'home' },
  {
    title: '文章分类',
    icon: 'folder-o',
    children: [
      { path: '/blog/article-classify/classify', title: '分类' },
      { path: '/blog/article-classify/labels', title: '标签' },
    ]
  },
  { path: '/blog/article-archive', title: '文章归档', icon: 'home' },
  { path: '/messageBoard', title: '留言板', icon: 'home' },
  { path: '/blog/info', title: '个人信息', icon: 'home' },

]
