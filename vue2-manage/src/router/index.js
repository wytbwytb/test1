import Vue from 'vue'
import Router from 'vue-router'
import studentView from "../page/studentView";

Vue.use(Router)

const login = r => require.ensure([], () => r(require('@/page/login')), 'login');

const libraryManage = r => require.ensure([], () => r(require('@/page/libraryManage')), 'libraryManage');
const libBook = r => require.ensure([], () => r(require('@/page/libBook')), 'libBook');
const libBookBorrow = r => require.ensure([], () => r(require('@/page/libBookBorrow')), 'libBookBorrow');
const libVisitor = r => require.ensure([], () => r(require('@/page/libVisitor')), 'libVisitor');
const libhome = r => require.ensure([], () => r(require('@/page/libhome')), 'libhome');

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
const deptSex = r => require.ensure([], () => r(require('@/page/deptSex')), 'deptSex');
const deptAge = r => require.ensure([], () => r(require('@/page/deptAge')), 'deptAge');
const deptGrade = r => require.ensure([], () => r(require('@/page/deptGrade')), 'deptGrade');
const depthome = r => require.ensure([], () => r(require('@/page/depthome')), 'depthome');

const otherManage = r => require.ensure([], () => r(require('@/page/otherManage')), 'otherManage');
const otherAssociation = r => require.ensure([], () => r(require('@/page/otherAssociation')), 'otherAssociation');
const otherDormBuilding = r => require.ensure([], () => r(require('@/page/otherDormBuilding')), 'otherDormBuilding');
const otherDormitory = r => require.ensure([], () => r(require('@/page/otherDormitory')), 'otherDormitory');
const otherStaff = r => require.ensure([], () => r(require('@/page/otherStaff')), 'otherStaff');
const otherStuDormClub = r => require.ensure([], () => r(require('@/page/otherStuDormClub')), 'otherStuDormClub');
const otherStaffDormBuilding = r => require.ensure([], () => r(require('@/page/otherStaffDormBuilding')), 'otherStaffDormBuilding');
const otherhome = r => require.ensure([], () => r(require('@/page/otherhome')), 'otherhome');


const superMan = r => require.ensure([], () => r(require('@/page/superMan')), 'superMan');
const superManage = r => require.ensure([], () => r(require('@/page/superManage')), 'superManage');

const studentView2 = r => require.ensure([], () => r(require('@/page/studentView')), 'studentView');
const studentSelectCourse = r => require.ensure([], () => r(require('@/page/studentSelectCourse')), 'studentSelectCourse');
const studentBorrowBook = r => require.ensure([], () => r(require('@/page/studentBorrowBook')), 'studentBorrowBook');
const studentGrade = r => require.ensure([], () => r(require('@/page/studentGrade')), 'studentGrade');
const studenthome = r => require.ensure([], () => r(require('@/page/studenthome')), 'studenthome');
const studentClub = r => require.ensure([], () => r(require('@/page/studentClub')), 'studentClub');
const studentRelation = r => require.ensure([], () => r(require('@/page/studentRelation')), 'studentRelation');

const passWord =  r => require.ensure([], () => r(require('@/page/passWord')), 'passWord');
const passManage =  r => require.ensure([], () => r(require('@/page/passManage')), 'passManage');


const routes = [
    {
        path: '/',
        component: login
    },
    {
        path: '/passWord',
        component: passWord,
    },
    {
        path: '/passManage',
        component: passManage,
        name:'',
        /*children: [{
            path: '/passWord',
            component: passWord,
        },]*/
    },
    {
        path: '/studentView',
        component: studentView2,
        name: '',
        children: [{
            path: '',
            component: studenthome,
        }, {
            path: '/studentGrade',
            component: studentGrade,
            meta: [],
        }, {
            path: '/studentSelectCourse',
            component: studentSelectCourse,
        }, {
            path: '/studentBorrowBook',
            component: studentBorrowBook,
        }, {
            path: '/studentClub',
            component: studentClub,
        }, {
            path: '/studentRelation',
            component: studentRelation,
        }
        ]
    },
    {
        path: '/superManage',
        component: superManage,
        name: '',
        children: [{
            path: '/superMan',
            component: superMan,
            meta: ['数据管理', '账号列表'],
        }]
    },

    {
        path: '/libraryManage',
        component: libraryManage,
        name: '',
        children: [{
            path: '',
            component: libhome,
            name: '',
        },{
            path: '/libBook',
            component: libBook,
            meta: ['数据管理', '图书列表'],
        }, {
            path: '/libBookBorrow',
            component: libBookBorrow,
            meta: ['数据管理', '借阅信息'],
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
            path: '',
            component: depthome,
            name: '',
        }, {
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
        }, {
            path: '/deptSex',
            component: deptSex,
            meta: ['图表', '性别分布'],
        }, {
            path: '/deptAge',
            component: deptAge,
            meta: ['图表', '年龄分布'],
        }, {
            path: '/deptGrade',
            component: deptGrade,
            meta: ['图表', '成绩分布'],
        }]
    },
    {
        path: '/otherManage',
        component: otherManage,
        name: '',
        children: [{
            path: '',
            component: otherhome,
            meta: [],
        }, {
            path: '/otherAssociation',
            component: otherAssociation,
            meta: ['数据管理', '社团列表'],

        }, {
            path: '/otherDormBuilding',
            component: otherDormBuilding,
            meta: ['数据管理', '公寓列表'],
        }, {
            path: '/otherDormitory',
            component: otherDormitory,
            meta: ['数据管理', '寝室列表'],
        }, {
            path: '/otherStaff',
            component: otherStaff,
            meta: ['数据管理', '职员列表'],
        }, {
            path: '/otherStaffDormBuilding',
            component: otherStaffDormBuilding,
            //meta: ['数据管理', '列表'],
        }, {
            path: '/otherStuDormClub',
            component: otherStuDormClub,

        }]
    },


]

export default new Router({
    routes,
    strict: process.env.NODE_ENV !== 'production',
})
