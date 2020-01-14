(this.webpackJsonpreact_security=this.webpackJsonpreact_security||[]).push([[0],{23:function(e,t,n){e.exports=n(37)},28:function(e,t,n){},37:function(e,t,n){"use strict";n.r(t);var a=n(0),l=n.n(a),r=n(18),o=n.n(r),c=(n(28),n(4)),i=n.n(c),u=n(10),s=n(9),m=n(11),d=n(6),E=n(19),v=n(20),g="http://localhost:8080/3rdSemExam";function h(e){return e.ok?e.json():Promise.reject({status:e.status,fullError:e.json()})}var p=new(function(){function e(){var t=this;Object(E.a)(this,e),this.setToken=function(e){localStorage.setItem("jwtToken",e)},this.getToken=function(){return localStorage.getItem("jwtToken")},this.loggedIn=function(){return console.log("loggedIn func"),null!=t.getToken()},this.logout=function(){localStorage.removeItem("jwtToken")},this.login=function(e,n){console.log("user, pass",e,n);var a=t.makeOptions("POST",!0,{username:e,password:n});return fetch(g+"/api/login",a).then(h).then((function(e){t.setToken(e.token)})).catch((function(e){throw e}))},this.getRole=function(){var e=localStorage.getItem("jwtToken").split(".")[1],t=window.atob(e);return JSON.parse(t).roles},this.fetchAllDrivers=function(){console.log("fetchingAllDrivers");var e=t.makeOptions("GET",!0);return fetch(g+"/api/exam/alldrivers",e).then(h)},this.fetchAllTrucks=function(){console.log("fetchingAllTrucks");var e=t.makeOptions("GET",!0);return fetch(g+"/api/exam/alltrucks",e).then(h)},this.deleteDriver=function(e){console.log("Deleting driver",e);var n=t.makeOptions("DELETE",!0);return fetch(g+"/api/exam/deletedriver/"+e,n)},this.editDriver=function(e,n){console.log("Editing driver",n);var a=t.makeOptions("PUT",!0,n);return fetch(g+"/api/exam/editdriver/"+e,a).then(h)},this.createDriver=function(e){console.log("Creating driver",e);var n=t.makeOptions("POST",!0,e);return fetch(g+"/api/exam/createdriver",n).then(h)},this.fetchPersonsByHobby=function(e){console.log("fetchingPersonsByHobby");var n=t.makeOptions("GET",!0);return fetch(g+"/api/person/hobby/"+e,n).then(h)},this.fetchPersonById=function(e){console.log("fetchingPersonById");var n=t.makeOptions("GET",!0);return fetch(g+"/api/person/id/"+e,n).then(h)},this.fetchPersonByEmail=function(e){console.log("fetchingPersonByEmail");var n=t.makeOptions("GET",!0);return fetch(g+"/api/person/email/"+e,n).then(h)},this.fetchPersonByPhone=function(e){console.log("fetchingPersonByPhone");var n=t.makeOptions("GET",!0);return fetch(g+"/api/person/phone/"+e,n).then(h)},this.fetchData=function(){console.log("fetchData");var e=t.makeOptions("GET",!0);return"admin"===t.getRole()?fetch(g+"/api/info/admin",e).then(h):fetch(g+"/api/info/user",e).then(h)}}return Object(v.a)(e,[{key:"makeOptions",value:function(e,t,n){console.log("makeOptions");var a={method:e,headers:{"Content-type":"application/json",Accept:"application/json"}};return t&&this.loggedIn()&&(a.headers["x-access-token"]=this.getToken()),n&&(a.body=JSON.stringify(n)),console.log("opts",a),a}}]),e}());var f=function(e){console.log("LogIn");var t=Object(a.useState)(""),n=Object(s.a)(t,2),r=n[0],o=n[1],c=Object(a.useState)(""),i=Object(s.a)(c,2),u=i[0],m=i[1];return console.log("user, pass",r,u),e.loggedIn?l.a.createElement("div",null,l.a.createElement("h2",null,"Logout"),l.a.createElement("button",{onClick:function(t){console.log("LogIn - logout"),t.preventDefault(),e.logout()}},"Logout")):l.a.createElement("div",null,l.a.createElement("h2",null,"Login"),l.a.createElement("form",{onChange:function(e){console.log("onChange  ->",e.target.id),"username"==[e.target.id]?(console.log("username",e.target.value),o(e.target.value)):(console.log("password",e.target.value),m(e.target.value))}},l.a.createElement("input",{placeholder:"User Name",id:"username"}),l.a.createElement("input",{placeholder:"Password",id:"password",type:"password"}),l.a.createElement("button",{onClick:function(t){console.log("LogIn - login"),t.preventDefault(),console.log("user, pass",r,u),e.login(r,u)}},"Login")))};var k=function(){return console.log("Home"),l.a.createElement("div",null,l.a.createElement("hr",null),l.a.createElement("h2",null,"Welcome to 3rdSemExam"),l.a.createElement("hr",null))},b=n(7),T=n.n(b);var D=function(e){var t=e.loggedIn,n=e.allDrivers,a=e.setAllDrivers;return console.log("Drivers"),"admin"===p.getRole()?l.a.createElement("div",null,l.a.createElement("h3",null,"Drivers"),l.a.createElement("hr",null),l.a.createElement("table",null,l.a.createElement("thead",null,l.a.createElement("tr",null,l.a.createElement("td",null,l.a.createElement("b",null,"Driver Id")),l.a.createElement("td",null,l.a.createElement("b",null,"First name")),l.a.createElement("td",null,l.a.createElement("b",null,"Last name")),l.a.createElement("td",null,l.a.createElement("b",null,"Truck name")))),l.a.createElement("tbody",null,n.map((function(e){return l.a.createElement("tr",{key:T()()},l.a.createElement("td",null,e.id),l.a.createElement("td",null,e.firstName),l.a.createElement("td",null,e.lastName),l.a.createElement("td",null,e.trucks[0].name))})))),l.a.createElement("hr",null),l.a.createElement("select",{id:"driverToDelete"},l.a.createElement("option",null," - select a Driver to delete - "),n.map((function(e){return l.a.createElement("option",{key:T()(),value:e.id},e.id," - ",e.firstName)})),";"),l.a.createElement("button",{onClick:function(){t&&function(){var e=Object(u.a)(i.a.mark((function e(){var t,n,l;return i.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,t=Number(document.getElementById("driverToDelete").value),console.log("driverToDelete",t),e.next=5,p.deleteDriver(t);case 5:return n=e.sent,console.log("Deleting Driver",n),e.next=9,p.fetchAllDrivers();case 9:l=e.sent,console.log("driverData",l),a(l),e.next=17;break;case 14:e.prev=14,e.t0=e.catch(0),console.log("err",e.t0);case 17:case"end":return e.stop()}}),e,null,[[0,14]])})));return function(){return e.apply(this,arguments)}}()()}},"Delete Driver"),l.a.createElement("hr",null),l.a.createElement("select",{id:"driverToEdit"},l.a.createElement("option",null," - select a Driver to edit - "),n.map((function(e){return l.a.createElement("option",{key:T()(),value:e.id},e.id," - ",e.firstName)})),";"),l.a.createElement("input",{placeholder:"First name",type:"text",id:"driverToEditFirstName"}),l.a.createElement("input",{placeholder:"Last name",type:"text",id:"driverToEditLastName"}),l.a.createElement("button",{onClick:function(){t&&function(){var e=Object(u.a)(i.a.mark((function e(){var t,n,l,r;return i.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,t=Number(document.getElementById("driverToEdit").value),n={firstName:document.getElementById("driverToEditFirstName").value,lastName:document.getElementById("driverToEditLastName").value},e.next=5,p.editDriver(t,n);case 5:return l=e.sent,console.log("Editing Driver",l),e.next=9,p.fetchAllDrivers();case 9:r=e.sent,console.log("driverData",r),a(r),e.next=17;break;case 14:e.prev=14,e.t0=e.catch(0),console.log("err",e.t0);case 17:case"end":return e.stop()}}),e,null,[[0,14]])})));return function(){return e.apply(this,arguments)}}()()}},"Edit Driver"),l.a.createElement("hr",null),l.a.createElement("input",{placeholder:"First name",type:"text",id:"driverToCreateFirstName"}),l.a.createElement("input",{placeholder:"Last name",type:"text",id:"driverToCreateLastName"}),l.a.createElement("button",{onClick:function(){t&&function(){var e=Object(u.a)(i.a.mark((function e(){var t,n,l;return i.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,t={firstName:document.getElementById("driverToCreateFirstName").value,lastName:document.getElementById("driverToCreateLastName").value},e.next=4,p.createDriver(t);case 4:return n=e.sent,console.log("Creating Driver",n),e.next=8,p.fetchAllDrivers();case 8:l=e.sent,console.log("driverData",l),a(l),e.next=16;break;case 13:e.prev=13,e.t0=e.catch(0),console.log("err",e.t0);case 16:case"end":return e.stop()}}),e,null,[[0,13]])})));return function(){return e.apply(this,arguments)}}()()}},"Create Driver"),l.a.createElement("hr",null)):"user"===p.getRole()?l.a.createElement("div",null,l.a.createElement("h3",null,"Drivers"),l.a.createElement("hr",null),l.a.createElement("table",null,l.a.createElement("thead",null,l.a.createElement("tr",null,l.a.createElement("td",null,l.a.createElement("b",null,"Driver Id")),l.a.createElement("td",null,l.a.createElement("b",null,"First name")),l.a.createElement("td",null,l.a.createElement("b",null,"Last name")),l.a.createElement("td",null,l.a.createElement("b",null,"Truck name")))),l.a.createElement("tbody",null,n.map((function(e){return l.a.createElement("tr",{key:T()()},l.a.createElement("td",null,e.id),l.a.createElement("td",null,e.firstName),l.a.createElement("td",null,e.lastName),l.a.createElement("td",null,e.trucks[0].name))})))),l.a.createElement("hr",null)):l.a.createElement("div",null,l.a.createElement("h2",null," Please login to view data"))};var y=function(e){var t=e.loggedIn,n=e.allTrucks;return e.setAllTrucks,console.log("Trucks"),t?l.a.createElement("div",null,l.a.createElement("h3",null,"Trucks"),l.a.createElement("hr",null),l.a.createElement("table",null,l.a.createElement("thead",null,l.a.createElement("tr",null,l.a.createElement("td",null,l.a.createElement("b",null,"Truck Id")),l.a.createElement("td",null,l.a.createElement("b",null,"Truck name")),l.a.createElement("td",null,l.a.createElement("b",null,"Capacity")))),l.a.createElement("tbody",null,n.map((function(e){return l.a.createElement("tr",{key:T()()},l.a.createElement("td",null,e.id),l.a.createElement("td",null,e.name),l.a.createElement("td",null,e.capacity))})))),l.a.createElement("hr",null)):l.a.createElement("div",null,l.a.createElement("h2",null," Please login to view data"))};function O(e){var t=e.loggedIn;return console.log("Header"),l.a.createElement("div",null,l.a.createElement("ul",{className:"header"},l.a.createElement("li",null,l.a.createElement(m.b,{exact:!0,activeClassName:"active",to:"/"},"Home")),l.a.createElement("li",null,l.a.createElement(m.b,{activeClassName:"active",to:"/drivers"},t?l.a.createElement("div",null,"Drivers"):l.a.createElement("div",{id:"navbar"}))),l.a.createElement("li",null,l.a.createElement(m.b,{activeClassName:"active",to:"/trucks"},t?l.a.createElement("div",null,"Trucks"):l.a.createElement("div",{id:"navbar"}))),l.a.createElement("li",null,l.a.createElement(m.b,{activeClassName:"active",to:"/log"},t?l.a.createElement("div",null,"Logout"):l.a.createElement("div",null,"Login")))))}function I(){return console.log("NoMatch"),l.a.createElement(k,null)}var x=function(){console.log("App");var e=localStorage.getItem("jwtToken"),t=Object(a.useState)(!!e),n=Object(s.a)(t,2),r=n[0],o=n[1],c=Object(a.useState)([]),E=Object(s.a)(c,2),v=E[0],g=E[1],h=Object(a.useState)([]),b=Object(s.a)(h,2),T=b[0],x=b[1];return Object(a.useEffect)((function(){r&&function(){var e=Object(u.a)(i.a.mark((function e(){var t,n;return i.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,p.fetchAllDrivers();case 3:return t=e.sent,console.log("driverData",t),g(t),e.next=8,p.fetchAllTrucks();case 8:n=e.sent,console.log("truckData",n),x(n),e.next=16;break;case 13:e.prev=13,e.t0=e.catch(0),console.log("err",e.t0);case 16:case"end":return e.stop()}}),e,null,[[0,13]])})));return function(){return e.apply(this,arguments)}}()()}),[r]),l.a.createElement("div",null,l.a.createElement(m.a,null,l.a.createElement("div",null,l.a.createElement(O,{loggedIn:r}),l.a.createElement(d.c,null,l.a.createElement(d.a,{exact:!0,path:"/"},l.a.createElement(k,null)),l.a.createElement(d.a,{path:"/drivers"},l.a.createElement(D,{loggedIn:r,allDrivers:v,setAllDrivers:g})),l.a.createElement(d.a,{path:"/trucks"},l.a.createElement(y,{loggedIn:r,allTrucks:T,setAllTrucks:x})),l.a.createElement(d.a,{path:"/log"},l.a.createElement(f,{facade:p,loggedIn:r,login:function(e,t){console.log("App - login"),p.login(e,t).then((function(e){return o(!0)})),console.log("loggedIn",r)},logout:function(){console.log("App - logout"),p.logout(),o(!1),console.log("loggedIn",r)}})),l.a.createElement(d.a,{component:I})))))};o.a.render(l.a.createElement(x,null),document.getElementById("root"))}},[[23,1,2]]]);
//# sourceMappingURL=main.58b6ca10.chunk.js.map