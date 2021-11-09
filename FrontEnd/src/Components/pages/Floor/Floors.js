import React, { useState, useEffect } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';  
import { connect } from 'react-redux';
import AlertDialog from '../DialogBox/AlertDialog';
import ComponentDialog from '../DialogBox/ComponentDialog';
import AddFloor from './AddFloor';
const FloorsList =(props) => {
    const[showDialog,setShowDialog]=useState(false);
    const[dialogTitle,setDialogTitle]=useState('');
    const [products, setProducts] = useState([
        {"id": "1000","code": "f230fh0g3","name": "Bamboo Watch","description": "Product Description","image": "bamboo-watch.jpg","price": 65,"category": "Accessories","quantity": 24,"inventoryStatus": "INSTOCK","rating": 5},
        {"id": "1001","code": "nvklal433","name": "Black Watch","description": "Product Description","image": "black-watch.jpg","price": 72,"category": "Accessories","quantity": 61,"inventoryStatus": "INSTOCK","rating": 4}, 
        
    ]); 

    useEffect(() => {  
    }, []); // eslint-disable-line react-hooks/exhaustive-deps
    const editFloor=(data)=>{
   console.log(data)
    }
    const deleteFloor=(data)=>{
console.log(data)
    }
    const onHide=()=>{
        setShowDialog(false); 
    }
const actionTemplate=(rowData)=>{
    return(
        <div>
        <a href='javascript:void(0)' className='ml-2' onClick={()=>editFloor(rowData)}>Edit</a>
        <a href='javascript:void(0)'  className='ml-2'onClick={()=>deleteFloor(rowData)}>Delete</a></div>
    )
}
const  createUser=()=>{ 
    setShowDialog(true);
    setDialogTitle('Create Floor')
}
    return (
        <div className='container '> 
         
            <div className="m-4 pt-3">
                <div className=''>
                <button className="btn btn-primary " onClick={createUser}> Add Floor</button> 
                </div>
            <div>
                <DataTable value={products}>
                    <Column field="floorName" header="Floor Name"></Column>  
                    <Column body={actionTemplate}  header="action"></Column>
                </DataTable>
                </div>
            </div>
            {showDialog?   <ComponentDialog
            isVisible={showDialog}
            DialogBody={AddFloor}
            onHide={onHide}
            header={dialogTitle}
            />:''}
        </div>
    );
}
const mapStateToProps=state=>({ 
})
const mapDispatchToProps=dispach=>({ 
})
export default connect(mapStateToProps,mapDispatchToProps)(FloorsList);
 