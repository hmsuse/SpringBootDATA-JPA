import Types from "./action-types"
import axios from 'axios'; 
import constants from "../Constants/constants";
 const loginRequest = (payload) => {
    return function (dispatch) {
        axios.post(constants.api.siginin+payload)
            .then((response) => dispatch({type:Types.LOGIN_SUCCESS,payload:response.data}))
            .catch((res) => alert("exception"))
    }  
}
const getUsersList= () => {
    return function (dispatch) {
        axios.post(constants.api.getUsersData)
            .then((response) => dispatch({type:Types.GET_USERS_LIST,payload:response.data}))
            .catch((res) => alert("exception"))
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
    getUsersList
}