function js(){
function addElementDiv(obj) {
    var parent = document.getElementById(obj);
    var div = document.createElement("div");
    div.setAttribute("class", "nc-container");
    div.setAttribute("id","dom_idc");
    parent.appendChild(div);
    var divc1=document.createElement("div");
    divc1.setAttribute("id","nc_2_wrapper");
    divc1.style.top="300px";
    divc1.setAttribute("class", "nc_wrapper");
    var divthird=document.createElement("div");
    divthird.setAttribute("id","nc_1_n1t");
    divthird.setAttribute("class", "nc_scale");
    var divthird01=document.createElement("div");
    divthird01.setAttribute("id","nc_1__bg");
    divthird01.setAttribute("class", "nc_bg");
    var spanthird02=document.createElement("span");
    spanthird02.setAttribute("id","nc_1_n1z");
    spanthird02.setAttribute("class", "nc_iconfont");
    spanthird02.setAttribute("class", "btn_slide");
    var divthird03=document.createElement("div");
    divthird03.setAttribute("id","nc_1__scale_text");
    divthird03.setAttribute("class", "scale_text");
    divthird03.setAttribute("class", "slidetounlock");
    var spanfourth1=document.createElement("span");
    spanfourth1.setAttribute("class", "nc-lang-cnt");
    spanfourth1.setAttribute("data-nc-lang", "_startTEXT");
    spanfourth1.innerHTML = "请按住滑块，拖动到最右边";
    divthird03.appendChild(spanfourth1);//添加到父集
    var divthird04=document.createElement("div");
    divthird04.setAttribute("id","nc_1_clickCaptcha");
    divthird04.setAttribute("class", "clickCaptcha");
    var divthird5=document.createElement("div");
    divthird5.setAttribute("class", "clickCaptcha_text");
    var divfive1=document.createElement("b");
    divfive1.setAttribute("id","nc_1__captcha_text");
    divfive1.setAttribute("class", "nc_captch_text");
    var divfivei=document.createElement("i");
    divfivei.setAttribute("id","nc_1__btn_2");
    divfivei.setAttribute("class", "nc_iconfont");
    divfivei.setAttribute("class", "nc_btn_2");
    divfivei.setAttribute("class", "btn_refresh");
    divthird5.appendChild(divfive1);
    divthird5.appendChild(divfivei);
    var divfive2=document.createElement("div");
    divfive2.setAttribute("class", "clickCaptcha_img");
    var divfive3=document.createElement("div");
    divfive3.setAttribute("class", "clickCaptcha_btn");
    divthird04.appendChild(divthird5);
    divthird04.appendChild(divfive2);
    divthird04.appendChild(divfive3);
    var divthird05=document.createElement("div");
    divthird05.setAttribute("id","nc_1_imgCaptcha");
    divthird05.setAttribute("class", "imgCaptcha");
    var divfive11=document.createElement("div");
    divfive11.setAttribute("class", "imgCaptcha_text");
    var inputfive12=document.createElement("input");
    inputfive12.setAttribute("id","nc_1_captcha_input");
    inputfive12.setAttribute("maxlength", "6");
    inputfive12.setAttribute("type", "text");
    inputfive12.setAttribute("style", "ime-mode:disabled");
    divfive11.appendChild(inputfive12);
    var divfive13=document.createElement("div");
    divfive13.setAttribute("id","nc_1__imgCaptcha_img");
    divfive13.setAttribute("class", "imgCaptcha_img");
    var finve14i=document.createElement("i");
    finve14i.setAttribute("id","nc_1__btn_1");
    finve14i.setAttribute("class", "nc_iconfont");
    finve14i.setAttribute("class", "nc_btn_1 btn_refresh");
    finve14i.setAttribute("onclick","document.getElementById('nc_1__imgCaptcha_img').children[0].click()");
    var divthird06=document.createElement("div");
    divthird06.setAttribute("id","imgCaptcha_btn");
    var five06=document.createElement("div");
    five06.setAttribute("id", "nc_1__captcha_img_text");
    five06.setAttribute("class", "nc_captcha_img_text");
    var five07=document.createElement("div");
    five07.setAttribute("id", "nc_1_scale_submit");
    five07.setAttribute("class", "nc_scale_submit");
    divthird06.appendChild(five06);
    divthird06.appendChild(five07);
    var divthird07=document.createElement("div");
    divthird07.setAttribute("id","nc_1_cc");
    divthird07.setAttribute("class","nc-cc");
    var divthird08=document.createElement("i");
    divthird08.setAttribute("id","nc_1__voicebtn");
    divthird08.setAttribute("class","nc_voicebtn");
    divthird08.setAttribute("class","nc_iconfont");
    divthird08.setAttribute("tabindex","0");
    divthird08.setAttribute("role","button");
    divthird08.setAttribute("style","display:none");
    divthird05.appendChild(divfive11);
    divthird05.appendChild(divfive13);
    divthird05.appendChild(finve14i);
    divthird05.appendChild(divthird06);
    divthird.appendChild(divthird01);
    divthird.appendChild(spanthird02);
    divthird.appendChild(divthird03);
    divthird.appendChild(divthird04);
    divthird.appendChild(divthird05);
    divthird.appendChild(divthird06);
    divthird.appendChild(divthird07);
    divthird.appendChild(divthird08);
    divc1.appendChild(divthird);
    var divc2=document.createElement("div");
    divc2.setAttribute("id","nc_1__voice");
    divc2.setAttribute("class", "nnc_voice");
    div.appendChild(divc1);
    div.appendChild(divc2);
    parent.appendChild(div);
}
addElementDiv("main");
}
function binding(){
var nc = new noCaptcha();
var nc_appkey = 'FFFF000000000176E36D';  // 应用标识,不可更改
var nc_scene = 'login';  //场景,不可更改
var nc_token = [nc_appkey, (new Date()).getTime(), Math.random()].join(':');
var nc_option = {
    renderTo: '#dom_idc',//渲染到该DOM ID指定的Div位置
    appkey: nc_appkey,
    scene: nc_scene,
    token: nc_token,
    callback: function (data) {// 校验成功回调
        document.getElementById('csessionid').value = data.csessionid;
        document.getElementById('sig').value = data.sig;
        document.getElementById('token').value = nc_token;
        document.getElementById('scene').value = nc_scene;

        var doc = document.getElementsByClassName('s_srand');//清空客户端验证滑块时的提示信息
        if(doc && doc.length>0){
            doc[0].innerText='';
        }
    }
};
nc.init(nc_option);
}
function margin(){
document.getElementById("nc_2_wrapper").style.marginLeft="auto";
document.getElementById("nc_2_wrapper").style.marginRight="auto";
document.getElementById("nc_2_wrapper").style.marginTop="300px";
document.getElementById("nc_2_wrapper").style.marginBottom="300px";
}