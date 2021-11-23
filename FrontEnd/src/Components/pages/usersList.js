import React, { useState, useEffect } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column'; 
import{getUsersList,editUsers} from '../actions/homeActions'
import { connect } from 'react-redux';
import ComponentDialog from './DialogBox/ComponentDialog';
import CreateUser from './CreateUser';
import AlertDialog from './DialogBox/AlertDialog';
const UsersList =(props) => {
    const[showDialog,setShowDialog]=useState(false)
    const[editRowData,setEditRowData]=useState('')
    const[dialogTitle,setDialogTitle]=useState('')
    const[showAlertDialog,setShowAlertDialog]=useState(false)
    const[responseMsg,setresponseMsg]=useState('')
    useEffect(() => { 
props.getUsersList();
    }, []); // eslint-disable-line react-hooks/exhaustive-deps
    const editUser=(data)=>{
        props.editUsers(data.user_id)
   console.log(data)
   setDialogTitle('Edit User')
   setShowDialog(true) 
    }
    const deleteUser=(data)=>{
setShowAlertDialog(true)
setresponseMsg('Are you sure you want to delete User')
setDialogTitle('Confirm Message')

    }
const actionTemplate=(rowData)=>{ 
    return(
        <div>
        <a href='javascript:void(0)' className='ml-2' onClick={()=>editUser(rowData)}>Edit</a>
        <a href='javascript:void(0)'  className='ml-2'onClick={()=>deleteUser(rowData)}>Delete</a></div>
    )
}
const onHide=()=>{
    setShowDialog(false);
    setShowAlertDialog(false)
}
const  createUser=()=>{
    setDialogTitle('Create User')
setShowDialog(true)
}
const successMethod=()=>{ 
}
    return (
        <div className='container '> 
         
            <div className="m-4 pt-3">
                <div className=''>
                <button className="btn btn-primary" onClick={createUser}> Add User</button> 
                </div>
            <div className=''>
                <DataTable  value={props.getUsersDetails}>
                    <Column field="userName" header="User Name"></Column>
                    <Column field="firstName" header="First Name"></Column>
                    <Column field="lastName" header="Last Name"></Column>
                    <Column field="email" header="Email"></Column>
                    <Column field="email" header="Phone Number
                    "></Column>
                    <Column body={actionTemplate} header="action"></Column>
                </DataTable>
                </div>
            </div>
         {showDialog?   <ComponentDialog
            isVisible={showDialog}
            DialogBody={CreateUser}
            onHide={onHide}
            header={dialogTitle}
            />:''}
           {showAlertDialog?<AlertDialog
               isVisible={showAlertDialog} 
               responseMsg={responseMsg}
               onHide={onHide}
               isOk={successMethod}
               header={dialogTitle}
           />:''} 
        </div>
    );
}
const mapStateToProps=state=>({
    getUsersDetails:state.reducers.getUsersDetails
})
const mapDispatchToProps=dispatch=>({
    getUsersList:()=>dispatch(getUsersList()),
    editUsers:(data)=>dispatch(editUsers(data)),
    deleteUsers:(id)=>dispatch(deleteUsers(id))
})
export default connect(mapStateToProps,mapDispatchToProps)(UsersList);
 