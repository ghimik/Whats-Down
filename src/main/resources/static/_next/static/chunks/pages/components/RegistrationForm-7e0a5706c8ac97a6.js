(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[924],{7450:function(e,t,r){(window.__NEXT_P=window.__NEXT_P||[]).push(["/components/RegistrationForm",function(){return r(8389)}])},8389:function(e,t,r){"use strict";r.r(t);var n=r(5893),s=r(7294),a=r(7066);r(2240),t.default=()=>{let[e,t]=(0,s.useState)(""),[r,o]=(0,s.useState)(""),[u,i]=(0,s.useState)({username:"",password:""}),[c,l]=(0,s.useState)(null);(0,s.useEffect)(()=>{let e=document.querySelector('meta[name="_csrf"]').getAttribute("content"),r=document.querySelector('meta[name="_csrf_header"]').getAttribute("content");t(e),o(r)},[]);let m=e=>{i({...u,[e.target.name]:e.target.value})};return(0,n.jsxs)("div",{className:"registration-form",children:[(0,n.jsxs)("form",{onSubmit:t=>{t.preventDefault(),a.Z.post("http://localhost:8081/auth/register",{username:u.username,password:u.password},{headers:{[r]:e}}).then(e=>{window.location.href="/home"}).catch(e=>{l("Ошибка регистрации. Попробуйте снова.")})},children:[(0,n.jsxs)("label",{children:["Имя пользователя:",(0,n.jsx)("input",{type:"text",name:"username",value:u.username,onChange:m,required:!0})]}),(0,n.jsxs)("label",{children:["Пароль:",(0,n.jsx)("input",{type:"password",name:"password",value:u.password,onChange:m,required:!0})]}),(0,n.jsx)("button",{type:"submit",children:"Зарегистрироваться"})]}),c&&(0,n.jsx)("span",{className:"error",children:c})]})}},2240:function(e){e.exports={"registration-form":"RegistrationForm_registration-form__ARc4I",error:"RegistrationForm_error__kM8Gi"}}},function(e){e.O(0,[66,888,774,179],function(){return e(e.s=7450)}),_N_E=e.O()}]);