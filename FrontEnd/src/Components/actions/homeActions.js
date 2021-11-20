import Types from "./action-types"
import axios from 'axios'; 
import constants from "../Constants/constants";
const exceptionHandler=(res)=>({
    type:EXCEPTION_HANDLER,

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
const addAndUpdateUsers=(data)=>{
    return function(dispatch){
        axios.post(constants.api.addUpdateOfUser+`?action=create`,data)
        .then(res=>dispatch({tupe:Types.ADD_AND_UPDATE_USER}))
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
    addAndUpdateUsers
}