<template>
    <div>
        <libHead-top></libHead-top>
        <el-row style="margin-top: 20px;">
            <el-col :span="12" :offset="4">
                <el-form :model="formBookData" :rules="rules" ref="formData" label-width="110px" class="demo-formData">
                    <el-form-item label="书籍名称" prop="name">
                        <el-input v-model="formBookData.name"></el-input>
                    </el-form-item>
                    <el-form-item label="书籍编号" prop="">
                        <el-input v-model="formBookData.bookId"></el-input>
                    </el-form-item>
                    <el-form-item label="书籍作者" prop="">
                        <el-input v-model="formBookData.bookAuthor"></el-input>
                    </el-form-item>
                    <el-form-item label="出版社" prop="">
                        <el-input v-model="formBookData.bookPublish"></el-input>
                    </el-form-item>
                    <el-form-item label="出版年份" prop="">
                        <el-input v-model="formBookData.bookPublishYear"></el-input>
                    </el-form-item>
                    <el-form-item label="借阅状态" prop="">
                        <el-input v-model="formBookData.bookStatus"></el-input>
                    </el-form-item>
                    <el-form-item class="button_submit">
                        <el-button type="primary" @click="submitForm('formBookData')">立即创建</el-button>
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import libHeadTop from "../components/libHeadTop";
    import {cityGuess, addShop, searchplace, foodCategory} from '@/api/getData'
    import {baseUrl, baseImgPath} from '@/config/env'
    export default {
        data(){
            return {
                formBookData:{
                    bookId:'',
                    bookName:'',
                    bookAuthor:'',
                    bookPublish:'',
                    bookPublishYear:'',
                    bookStatus:''
                },
                rules: {
                    bookId: [
                        { required: true, message: '请输入书籍编号', trigger: 'blur' },
                    ],
                    bookName: [
                        { required: true, message: '请输入书名', trigger: 'blur' }
                    ],
                },
            }
        },
        components: {
            libHeadTop,
        },
        mounted(){
            this.initData();
        },
        methods: {
            async initData(){
                try{
                    this.city = await cityGuess();
                    const categories = await foodCategory();
                    categories.forEach(item => {
                        if (item.sub_categories.length) {
                            const addnew = {
                                value: item.name,
                                label: item.name,
                                children: []
                            }
                            item.sub_categories.forEach((subitem, index) => {
                                if (index == 0) {
                                    return
                                }
                                addnew.children.push({
                                    value: subitem.name,
                                    label: subitem.name,
                                })
                            })
                            this.categoryOptions.push(addnew)

                        }
                    })
                }catch(err){
                    console.log(err);
                }
            },
            async querySearchAsync(queryString, cb) {
                /*if (queryString) {
                    try{
                        const cityList = await searchplace(this.city.id, queryString);
                        if (cityList instanceof Array) {
                            cityList.map(item => {
                                item.value = item.address;
                                return item;
                            })
                            cb(cityList)
                        }
                    }catch(err){
                        console.log(err)
                    }
                }*/
            },
            submitForm(formName) {
                this.$refs[formName].validate(async (valid) => {
                    if (valid) {
                        Object.assign(this.formData, {activities: this.activities}, {
                            category: this.selectedCategory.join('/')
                        })
                        try{
                            let result = await addShop(this.formData);
                            if (result.status == 1) {
                                this.$message({
                                    type: 'success',
                                    message: '添加成功'
                                });
                                this.formData = {
                                    name: '', //店铺名称
                                    address: '', //地址
                                    latitude: '',
                                    longitude: '',
                                    description: '', //介绍
                                    phone: '',
                                    promotion_info: '',
                                    float_delivery_fee: 5, //运费
                                    float_minimum_order_amount: 20, //起价
                                    is_premium: true,
                                    delivery_mode: true,
                                    new: true,
                                    bao: true,
                                    zhun: true,
                                    piao: true,
                                    startTime: '',
                                    endTime: '',
                                    image_path: '',
                                    business_license_image: '',
                                    catering_service_license_image: '',
                                };
                                this.selectedCategory = ['快餐便当', '简餐'];
                                this.activities = [{
                                    icon_name: '减',
                                    name: '满减优惠',
                                    description: '满30减5，满60减8',
                                }];
                            }else{
                                this.$message({
                                    type: 'error',
                                    message: result.message
                                });
                            }
                            console.log(result)
                        }catch(err){
                            console.log(err)
                        }
                    } else {
                        this.$notify.error({
                            title: '错误',
                            message: '请检查输入是否正确',
                            offset: 100
                        });
                        return false;
                    }
                });
            },
        }
    }
</script>

<style lang="less">
    @import '../style/mixin';
    .button_submit{
        text-align: center;
    }
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #20a0ff;
    }
    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 120px;
        height: 120px;
        line-height: 120px;
        text-align: center;
    }
    .avatar {
        width: 120px;
        height: 120px;
        display: block;
    }
    .el-table .info-row {
        background: #c9e5f5;
    }

    .el-table .positive-row {
        background: #e2f0e4;
    }
</style>
