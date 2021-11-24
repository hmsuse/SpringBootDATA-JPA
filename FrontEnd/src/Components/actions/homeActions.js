import Types from "./action-types"
import axios from 'axios'; 
import constants from "../Constants/constants";
const exceptionHandler=(res)=>({
    type:Types.EXCEPTION_HANDLER,

})
const createUser=()=>({
    type:Types.CREATE_USER,

});
const nullifyService=()=>({
    type:Types.NULLIFY_SERVICE,
})
 const loginRequest = (payload) => {
    return function (dispatch) {
        axios.post(constants.api.siginin+payload)
            .then((response) => dispatch({type:Types.LOGIN_SUCCESS,payload:response.data}))
            .catch((res) => dispatch(exceptionHandler(res)))
    }  
}
const getUsersList= () => {
    return function (dispatch) {
        axios.post(constants.api.getUsersData)
            .then((response) => dispatch({type:Types.GET_USERS_LIST,payload:response.data}))
            .catch((res) =>dispatch(exceptionHandler(res)))
    }  
}
//add and update users list
const addAndUpdateUsers=(data,type)=>{
    return function(dispatch){
        axios.post(constants.api.addUpdateOfUser+`?action=${type}`,data)
        .then(res=>{
            dispatch({type:Types.ADD_AND_UPDATE_USER,payload:res.data})  
            if(res.data.status =='success'){
dispatch(getUsersList())
            }
        })
        .catch(res=>dispatch(exceptionHandler(res)))
    }
}
const editUsers=(data)=>{
    return function(dispatch){
        axios.post(constants.api.editUser+`?userId=${data}`)
        .then(res=>dispatch({type:Types.EDIT_USER,res:res.data}))
        .catch(res=>dispatch(exceptionHandler(res)))
    }
}
const deleteUsers=(data)=>{
    return function(dispatch){
        axios.post(constants.api.deleteUser+`?userId=${data}`)
        .then(res=>{dispatch({type:Types.DELETE_USER,payload:res.data})
    if(res.data.status == 'success'){
        dispatch(getUsersList())
    }
    })
        .catch(res=>dispatch(exceptionHandler(res)))
    }
}
const AddorUpdateFloor=()=>{
    return function(dispatch){
        axios.post()
        .then((response)=>dispatch({type:Types.ADD_AND_UPDATE_FLOOR_LIST,payload:response.data}))
        .catch((res) => alert("exception"))
    }
}

export {
    loginRequest,
    getUsersList,
    addAndUpdateUsers,
    editUsers,
    deleteUsers,
    createUser,
    nullifyService
}