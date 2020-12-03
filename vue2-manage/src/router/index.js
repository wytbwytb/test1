import Vue from 'vue'
import Router from 'vue-router'
import studentView from "../page/studentView";

Vue.use(Router)

const login = r => require.ensure([], () => r(require('@/page/login')), 'login');
const manage = r => require.ensure([], () => r(require('@/page/manage')), 'manage');

const libraryManage = r => require.ensure([], () => r(require('@/page/libraryManage')), 'libraryManage');
const libBook = r => require.ensure([], () => r(require('@/page/libBook')), 'libBook');
const libBookBorrow = r => require.ensure([], () => r(require('@/page/libBookBorrow')), 'libBookBorrow');
const libAdminList = r => require.ensure([], () => r(require('@/page/libAdminList')), 'libAdminList');
const libAddBook = r => require.ensure([], () => r(require('@/page/libAddBook')), 'libAddBook');
const libVisitor = r => require.ensure([], () => r(require('@/page/libVisitor')), 'libVisitor');

const deptManage = r => require.ensure([], () => r(require('@/page/deptManage')), 'deptManage');
const deptList = r => require.ensure([], () => r(require('@/page/deptList')), 'deptList');
const deptTeacherList = r => require.ensure([], () => r(require('@/page/deptTeacherList')), 'deptTeacherList');
const deptClassList = r => require.ensure([], () => r(require('@/page/deptClassList')), 'deptClassList');
const deptStudentList = r => require.ensure([], () => r(require('@/page/deptStudentList')), 'deptStudentList');
const deptClassroomList = r => require.ensure([], () => r(require('@/page/deptClassroomList')), 'deptClassroomList');
const deptCourseList = r => require.ensure([], () => r(require('@/page/deptCourseList')), 'deptCourseList');
const deptClassStudent = r => require.ensure([], () => r(require('@/page/deptClassStudent')), 'deptClassStudent');
const deptStudentCourse = r => require.ensure([], () => r(require('@/page/deptStudentCourse')), 'deptStudentCourse');
const deptTeacherCourse = r => require.ensure([], () => r(require('@/page/deptTeacherCourse')), 'deptTeacherCourse');
const deptCourseBook = r => require.ensure([], () => r(require('@/page/deptCourseBook')), 'deptCourseBook');

const otherManage = r => require.ensure([], () => r(require('@/page/otherManage')), 'otherManage');
const otherAssociation = r => require.ensure([], () => r(require('@/page/otherAssociation')), 'otherAssociation');
const otherDormBuilding = r => require.ensure([], () => r(require('@/page/otherDormBuilding')), 'otherDormBuilding');
const otherDormitory = r => require.ensure([], () => r(require('@/page/otherDormitory')), 'otherDormitory');
const otherStaff = r => require.ensure([], () => r(require('@/page/otherStaff')), 'otherStaff');
const otherStuDormClub = r => require.ensure([], () => r(require('@/page/otherStuDormClub')), 'otherStuDormClub');
const otherStaffDormBuilding = r => require.ensure([], () => r(require('@/page/otherStaffDormBuilding')), 'otherStaffDormBuilding');

const superMan = r => require.ensure([], () => r(require('@/page/superMan')), 'superMan');

const studentView2 = r => require.ensure([], () => r(require('@/page/studentView')), 'studentView');
const studentSelectCourse = r => require.ensure([], () => r(require('@/page/studentSelectCourse')), 'studentSelectCourse');
const studentBorrowBook = r => require.ensure([], () => r(require('@/page/studentBorrowBook')), 'studentBorrowBook');
const studentGrade = r => require.ensure([], () => r(require('@/page/studentGrade')), 'studentGrade');


const home = r => require.ensure([], () => r(require('@/page/home')), 'home');
const addShop = r => require.ensure([], () => r(require('@/page/addShop')), 'addShop');
const addGoods = r => require.ensure([], () => r(require('@/page/addGoods')), 'addGoods');
const userList = r => require.ensure([], () => r(require('@/page/userList')), 'userList');
const shopList = r => require.ensure([], () => r(require('@/page/shopList')), 'shopList');
const foodList = r => require.ensure([], () => r(require('@/page/foodList')), 'foodList');
const orderList = r => require.ensure([], () => r(require('@/page/orderList')), 'orderList');
const adminList = r => require.ensure([], () => r(require('@/page/adminList')), 'adminList');
const visitor = r => require.ensure([], () => r(require('@/page/visitor')), 'visitor');
const newMember = r => require.ensure([], () => r(require('@/page/newMember')), 'newMember');
const uploadImg = r => require.ensure([], () => r(require('@/page/uploadImg')), 'uploadImg');
const vueEdit = r => require.ensure([], () => r(require('@/page/vueEdit')), 'vueEdit');
const adminSet = r => require.ensure([], () => r(require('@/page/adminSet')), 'adminSet');
const sendMessage = r => require.ensure([], () => r(require('@/page/sendMessage')), 'sendMessage');
const explain = r => require.ensure([], () => r(require('@/page/explain')), 'explain');

const routes = [
    {
        path: '/',
        component: login
    },
    {
        path: '/studentView',
        component: studentView2,
        name: '',
        children: [{
            path: '/studentGrade',
            component: studentGrade,
            meta: [],
        },{
            path: '/studentSelectCourse',
            component: studentSelectCourse,
            meta: ['添加数据', '添加商铺'],
        },{
            path: '/studentBorrowBook',
            component: studentBorrowBook,
        }]
    },
    {
        path: '/superManage',
        component: superMan
    },
    {
        path: '/manage',
        component: manage,
        name: '',
        children: [{
            path: '',
            component: home,
            meta: [],
        }, {
            path: '/addShop',
            component: addShop,
            meta: ['添加数据', '添加商铺'],
        }, {
            path: '/addGoods',
            component: addGoods,
            meta: ['添加数据', '添加商品'],
        }, {
            path: '/userList',
            component: userList,
            meta: ['数据管理', '用户列表'],
        }, {
            path: '/shopList',
            component: shopList,
            meta: ['数据管理', '商家列表'],
        }, {
            path: '/foodList',
            component: foodList,
            meta: ['数据管理', '食品列表'],
        }, {
            path: '/orderList',
            component: orderList,
            meta: ['数据管理', '订单列表'],
        }, {
            path: '/adminList',
            component: adminList,
            meta: ['数据管理', '管理员列表'],
        }, {
            path: '/visitor',
            component: visitor,
            meta: ['图表', '用户分布'],
        }, {
            path: '/newMember',
            component: newMember,
            meta: ['图表', '用户数据'],
        }, {
            path: '/uploadImg',
            component: uploadImg,
            meta: ['文本编辑', 'MarkDown'],
        }, {
            path: '/vueEdit',
            component: vueEdit,
            meta: ['编辑', '文本编辑'],
        }, {
            path: '/adminSet',
            component: adminSet,
            meta: ['设置', '管理员设置'],
        }, {
            path: '/sendMessage',
            component: sendMessage,
            meta: ['设置', '发送通知'],
        }, {
            path: '/explain',
            component: explain,
            meta: ['说明', '说明'],
        }]
    },
    {
        path: '/libraryManage',
        component: libraryManage,
        name: '',
        children: [{
            path: '/libAddBook',
            component: libAddBook,
            meta: ['添加数据', '添加图书'],
        }, {
            path: '/libBook',
            component: libBook,
            meta: ['数据管理', '图书列表'],
        }, {
            path: '/libBookBorrow',
            component: libBookBorrow,
            meta: ['数据管理', '借阅信息'],
        }, {
            path: '/libAdminList',
            component: libAdminList,
            meta: ['数据管理', '管理员列表'],
        }, {
            path: '/libVisitor',
            component: libVisitor,
            meta: ['图表', '借阅书籍分布'],
        }]
    },
    {
        path: '/deptManage',
        component: deptManage,
        name: '',
        children: [{
            path: '/deptList',
            component: deptList,
            meta: ['数据管理', '院系列表'],
        }, {
            path: '/deptTeacherList',
            component: deptTeacherList,
            meta: ['数据管理', '教师列表'],
        }, {
            path: '/deptClassList',
            component: deptClassList,
            meta: ['数据管理', '班级列表'],
        }, {
            path: '/deptStudentList',
            component: deptStudentList,
            meta: ['数据管理', '学生列表'],
        }, {
            path: '/deptClassroomList',
            component: deptClassroomList,
            meta: ['数据管理', '教室列表'],
        }, {
            path: '/deptCourseList',
            component: deptCourseList,
            meta: ['数据管理', '课程列表'],
        }, , {
            path: '/deptClassStudent',
            component: deptClassStudent,
            meta: ['关系管理', '班级-学生'],
        }, {
            path: '/deptCourseBook',
            component: deptCourseBook,
            meta: ['关系管理', '课程书籍'],
        }, {
            path: '/deptStudentCourse',
            component: deptStudentCourse,
            meta: ['关系管理', '学生选课'],
        }, , {
            path: '/deptTeacherCourse',
            component: deptTeacherCourse,
            meta: ['关系管理', '教师授课'],
        }, {
            path: '/libVisitor',
            component: libVisitor,
            meta: ['图表', '借阅书籍分布'],
        }]
    },
    {
        path: '/otherManage',
        component: otherManage,
        name: '',
        children: [{
            path: '/otherAssociation',
            component: otherAssociation,
            meta: ['数据管理', '院系列表'],
        }, {
            path: '/otherDormBuilding',
            component: otherDormBuilding,
            meta: ['数据管理', '教师列表'],
        }, {
            path: '/otherDormitory',
            component: otherDormitory,
            meta: ['数据管理', '班级列表'],
        }, {
            path: '/otherStaff',
            component: otherStaff,
            meta: ['数据管理', '学生列表'],
        }, {
            path: '/otherStaffDormBuilding',
            component: otherStaffDormBuilding,
            meta: ['数据管理', '教室列表'],
        }, {
            path: '/otherStuDormClub',
            component: otherStuDormClub,
            meta: ['数据管理', '课程列表'],
        }, , {
            path: '/deptClassStudent',
            component: deptClassStudent,
            meta: ['关系管理', '班级-学生'],
        }, {
            path: '/deptCourseBook',
            component: deptCourseBook,
            meta: ['关系管理', '课程书籍'],
        }, {
            path: '/deptStudentCourse',
            component: deptStudentCourse,
            meta: ['关系管理', '学生选课'],
        }, , {
            path: '/deptTeacherCourse',
            component: deptTeacherCourse,
            meta: ['关系管理', '教师授课'],
        }, {
            path: '/libVisitor',
            component: libVisitor,
            meta: ['图表', '借阅书籍分布'],
        }]
    },
]

export default new Router({
    routes,
    strict: process.env.NODE_ENV !== 'production',
})
