(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[214],{2923:function(n,t,e){(window.__NEXT_P=window.__NEXT_P||[]).push(["/components/AuthButtons",function(){return e(7453)}])},7453:function(n,t,e){"use strict";e.r(t);var s=e(5893),r=e(7294),u=e(7066),a=e(2646),o=e(1318),c=e.n(o);t.default=()=>{let[n,t]=(0,r.useState)(null);return(0,r.useEffect)(()=>{u.Z.get("/data/user").then(n=>{t(n.data)}).catch(n=>{console.log("User is not authenticated")})},[]),(0,s.jsx)("div",{className:c().authButtons,children:n?(0,s.jsx)(a.default,{username:n.username}):(0,s.jsxs)(s.Fragment,{children:[(0,s.jsx)("button",{onClick:()=>window.location.href="/login",children:"Войти"}),(0,s.jsx)("button",{onClick:()=>window.location.href="/register",children:"Регистрация"})]})})}},2646:function(n,t,e){"use strict";e.r(t);var s=e(5893);e(7294);var r=e(9157),u=e.n(r);t.default=n=>{let{username:t}=n;return(0,s.jsxs)("div",{className:u().userInfo,children:[(0,s.jsxs)("p",{className:u().paragraph,children:["Привет, ",t,"!"]}),(0,s.jsx)("a",{className:u().link,href:"/home",children:"Перейти к чатам"})]})}},1318:function(n){n.exports={authButtons:"AuthButtons_authButtons__JF2bO"}},9157:function(n){n.exports={userInfo:"UserInfo_userInfo__6ODcq",paragraph:"UserInfo_paragraph__uO3IV",link:"UserInfo_link__wKs9j"}}},function(n){n.O(0,[66,888,774,179],function(){return n(n.s=2923)}),_N_E=n.O()}]);