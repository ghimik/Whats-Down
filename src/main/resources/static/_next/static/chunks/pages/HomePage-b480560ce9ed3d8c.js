(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[544],{3303:function(e,t,a){(window.__NEXT_P=window.__NEXT_P||[]).push(["/HomePage",function(){return a(1536)}])},1536:function(e,t,a){"use strict";a.r(t);var s=a(5893),n=a(7294),c=a(7066),r=a(9327),o=a(5480),l=a(497);t.default=function(){let[e,t]=(0,n.useState)(""),[a,i]=(0,n.useState)(""),[u,d]=(0,n.useState)(null),[h,m]=(0,n.useState)(null),[f,_]=(0,n.useState)([]);(0,n.useEffect)(()=>{let s=document.querySelector('meta[name="_csrf"]').getAttribute("content"),n=document.querySelector('meta[name="_csrf_header"]').getAttribute("content");t(s),i(n),(async()=>{try{let t=await c.Z.get("http://localhost:8081/data/user",{headers:{[a]:e}});d(t.data)}catch(e){console.error(e),window.location.href="http://localhost:8081/login"}})(),c.Z.get("http://localhost:8081/data/chats",{headers:{[a]:e}}).then(e=>{_(e.data.contacts),console.log(e.data)}).catch(e=>console.error(e))},[]);let p=async t=>c.Z.post("http://localhost:8081/contacts/add/".concat(t),{headers:{[a]:e}}).then(alert("".concat(t," добавлен в контакты."))).catch(e=>alert(e)),x=async t=>c.Z.post("http://localhost:8081/contacts/remove/".concat(t),{headers:{[a]:e}}).then(alert("".concat(t," добавлен в контакты."))).catch(e=>alert(e));return(0,s.jsx)("div",{className:"home-page",children:u?(0,s.jsxs)(s.Fragment,{children:[(0,s.jsx)(r.default,{username:u.username,onLogout:()=>{window.location.href="http://localhost:8081/logout"}}),(0,s.jsxs)("div",{className:"content",children:[(0,s.jsx)(o.default,{chats:f,onSelectChat:m,onAddContact:p,onRemoveContact:x}),(0,s.jsx)(l.default,{chat:h,myUsername:u.username})]})]}):(0,s.jsx)("p",{children:"Загрузка данных пользователя..."})})}},5480:function(e,t,a){"use strict";a.r(t);var s=a(5893),n=a(7294);a(2481),t.default=e=>{let{chats:t=[],onSelectChat:a,onAddContact:c,onRemoveContact:r}=e,[o,l]=(0,n.useState)(""),i=(e,t)=>{e.stopPropagation(),r(t)};return(0,s.jsxs)("div",{className:"chat-list",children:[(0,s.jsx)("h3",{children:"Список чатов"}),(0,s.jsx)("ul",{children:t.map(e=>(0,s.jsxs)("li",{onClick:()=>a(e),children:[e.friendName,(0,s.jsx)("button",{onClick:t=>i(t,e),children:"Удалить из друзей"})]},e.id))}),(0,s.jsxs)("div",{className:"add-contact",children:[(0,s.jsx)("input",{type:"text",placeholder:"Добавить контакт",value:o,onChange:e=>l(e.target.value)}),(0,s.jsx)("button",{onClick:()=>{o.trim()?(c(o.trim()),l("")):alert("Введите имя пользователя.")},children:"Добавить"})]})]})}},497:function(e,t,a){"use strict";a.r(t);var s=a(5893),n=a(7294),c=a(7066);a(4816);var r=a(8748),o=a(8e3),l=a.n(o);t.default=function(e){let{chat:t,myUsername:a}=e,[o,i]=(0,n.useState)(""),[u,d]=(0,n.useState)(""),[h,m]=(0,n.useState)([]),[f,_]=(0,n.useState)(""),p=(0,n.useRef)(null);return((0,n.useEffect)(()=>{let e=document.querySelector('meta[name="_csrf"]').getAttribute("content"),a=document.querySelector('meta[name="_csrf_header"]').getAttribute("content");if(i(e),d(a),t)return(async()=>{try{let e=await c.Z.get("http://localhost:8081/data/chat?with=".concat(t.friendName),{headers:{[u]:o}});m(e.data.messages),console.log(e.data)}catch(e){console.error(e)}})(),function(){let e=new(l())("http://localhost:8081/ws");p.current=new r.K({webSocketFactory:()=>e,onConnect:e=>{p.current.subscribe("/topic/messages",e=>{var t;t=JSON.parse(e.body),m(e=>[...e,t]),console.log("Received message: ",t)})}}),p.current.activate()}(),()=>{p.current&&p.current.deactivate()}},[t]),t)?(0,s.jsxs)("div",{className:"chat-window",children:[(0,s.jsxs)("h3",{children:["Чат с ",t.friendName]}),(0,s.jsx)("div",{className:"messages",children:h.map((e,t)=>(0,s.jsxs)("div",{className:e.sender.username===a?"message sent":"message received",children:[(0,s.jsxs)("strong",{children:[e.sender.username,":"]})," ",e.text]},t))}),(0,s.jsx)("input",{className:"textInput",type:"text",value:f,onChange:e=>_(e.target.value),placeholder:"Напишите сообщение..."}),(0,s.jsx)("button",{onClick:function(){p.current.publish({destination:"/app/sendMessage",body:JSON.stringify({text:f,sender:{username:a}})}),_("")},children:"Отправить сообщение"})]}):(0,s.jsx)("p",{children:"Выберите чат для просмотра сообщений"})}},9327:function(e,t,a){"use strict";a.r(t);var s=a(5893);a(7294),a(5923),t.default=e=>{let{username:t,onLogout:a}=e;return(0,s.jsxs)("div",{className:"user-header",children:[(0,s.jsxs)("span",{children:["Привет, ",t,"!"]}),(0,s.jsx)("button",{onClick:a,children:"Выйти"}),(0,s.jsx)("a",{href:"/",children:"Перейти на домашнюю страницу"})]})}},2481:function(e){e.exports={"chat-list":"ChatList_chat-list__zoPG8"}},4816:function(e){e.exports={"chat-window":"ChatWindow_chat-window__uTtLp",messages:"ChatWindow_messages__wVkoP",message:"ChatWindow_message__f8sDp",sent:"ChatWindow_sent__V6Wby",received:"ChatWindow_received__YzJmy",textInput:"ChatWindow_textInput__Rs8Tb"}},5923:function(e){e.exports={"user-header":"UserHeader_user-header__BCiMW"}}},function(e){e.O(0,[66,505,888,774,179],function(){return e(e.s=3303)}),_N_E=e.O()}]);