const url='http://localhost:9091/api/v1';

const constants={
 header:{ 
        // authorization: 'Bareers',
        "content-Type": 'application/json', 
        'Origin':'http://localhost:9091'
},
api:{
    siginin:url+'/login',
    getUsersData:url+'/getUsersData',
    addUpdateOfUser:url+'/addUpdateOfUser',
    editUser:url+'/editUser',
    deleteUser:url+'/deleteUser'
}
}
export default constants;