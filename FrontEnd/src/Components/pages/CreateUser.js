import React, { useState, useEffect } from 'react';
const CreateUser=(props)=>{
  const [user,setUser]=useState({userName:'',firstName:'',lastName:'',userType:'',email:'',phoneNumber:''})
 useEffect(()=>{

 },[])
 const changeUserNameHandler=(e)=>{
setUser({...user,userName:e.target.value})
 }
 const changeFirstNameHandler=(e)=>{
  setUser({...user,firstName:e.target.value})

}
const changeLastNameHandler=(e)=>{
  setUser({...user,lastName:e.target.value})
}
const changeUserTypeHandler=(e)=>{
  setUser({...user,userType:e.target.value})
}
const changeEmailHandler=(e)=>{
  setUser({...user,email:e.target.value})
}
const changephoneNumberHandler=(e)=>{
  setUser({...user,phoneNumber:e.target.value})
} 
const onSubmitHandler=()=>{
  console.log(user)
}
    return(
        <div>
            <div className='row'>
            <div class="form-group col-sm-6">
             <label for="usr">User Name:</label>
              <input type="text" value={user.userName} onChange={changeUserNameHandler} placeholder='User Name' name='userName' class="form-control"/>
            </div>
          <div class="form-group col-sm-6">
          <label for="usr">First Name:</label>
          <input type="text" name='fname' onChange={changeFirstNameHandler} value={user.firstName} placeholder='First Name' class="form-control"/>
          </div>
          </div>
       <div className='row'>
       <div class="form-group col-sm-6">
       <label for="usr">Last Name:</label>
       <input type="text" name='lName' onChange={changeLastNameHandler} value={user.lastName} placeholder='Last Name' class="form-control"/>
      </div>
     <div class="form-group col-sm-6">
       <label for="sel1">User Type:</label>
       <select class="form-control" onChange={changeUserTypeHandler} value={user.userType}>
       <option>select User</option>
      <option>Admin</option>
      <option>Accountant</option> 
     </select>
     </div>
    </div> 
   <div className='row'>
       <div class="form-group col-sm-6">
     <label for="usr">Email:</label>
     <input type="text" name='email' onChange={changeEmailHandler} value={user.email} placeholder='Email' class="form-control"/>
   </div>
   <div class="form-group col-sm-6">
   <label for="usr">Phone Number:</label>
   <input type="number" name='phno' onChange={changephoneNumberHandler} value={user.phoneNumber} placeholder='Phone Number' class="form-control"/>
   </div>
   </div> 
   <div className='float-right'>
   <button type='btn' className='btn btn-danger mr-2' onClick={props.onHide}>Cancel</button>
    <button type='submit' className='btn btn-primary' onClick={onSubmitHandler}>Submit</button>
   </div>
  </div> 
    );
}
export default CreateUser;