import React, { useEffect, useState } from 'react'
import CustomerService from '../services/CustomerService';
import { Link, useNavigate, useParams } from 'react-router-dom';

export const AddCustomerComponent = () => {
    //creo mi constante para guardar los datos y luego mandarlos a la bd
    const[name,setName] = useState('');
    const[surname,setSurname] = useState('');
    const[email,setEmail] = useState('');

    //este hook me sirve para poder utilizar esta constante como parámetro
    //y lo guardo en useEffect
    const {id} = useParams();
    //creo el hook useNavigate();
    const navigate = useNavigate();

    //esto es para guardar mi cliente cuando le de click en guardar
    const saveOrUpdateCustomer = (e) => {
        e.preventDefault();
        const customer = { name, surname, email};
        //pongo este if para saber si es nulo o no el id y crear o actualizar el registro
        if(id!=null){
            CustomerService.updateCustomerById(id,customer).then((response) => {
            //esto es para ver si se imprime correctamente nuestro post
            console.log(response.data);
            //uso el hook navigate para cuando le de en guardar me mande a la lista de clientes
            navigate('/customers');
        }).catch((error) =>{
            console.log(error)
        })
        }else{
            CustomerService.createCustomer(customer).then((response) => {
            //esto es para ver si se imprime correctamente nuestro post
            console.log(response.data);
            //uso el hook navigate para cuando le de en guardar me mande a la lista de clientes
            navigate('/customers');
        }).catch((error) =>{
            console.log(error)
        })
        }
    }

    //ahora uso un useEffect() como efecto secundario y me traiga los datos del cliente
    //cuando quiera actualizar los valores
    useEffect(() => {
        CustomerService.getCustomerById(id).then((response) => {
            setName(response.data.name);
            setSurname(response.data.surname);
            setEmail(response.data.email);
        }).catch((error) => {
            console.log(error);
        })
    },[]) //muy importante poner los corchetes [] para que me deje modificar los valores del cliente

    //esta constante me devuelve el titulo del form si es nulo quiere decir
    //que voy agregar un cliente sino es que lo voy actualizar
    const title = () => {
        if(id != null){
            return <h2 className='text-center'>Actualizar cliente</h2>
        }else{
            return <h2 className='text-cener'>Registrar cliente</h2>
        }
    }
  return (
    <div>
        <div className='container'>
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    <h2 className='text-center'>
                        {
                            title()
                        }
                    </h2>
                    <div className='card-body'>
                        <form>
                            <div className='form-group mb-2'>
                                <label className='form-label'>name</label>
                                <input 
                                    type='text' 
                                    placeholder='Escribe tu nombre'
                                    name='name'
                                    className='form-control'
                                    value={name}
                                    onChange={ (e) => setName(e.target.value)}    
                                />
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>surname</label>
                                <input 
                                    type='text' 
                                    placeholder='Escribe tu apellido'
                                    name='surname'
                                    className='form-control'
                                    value={surname}
                                    onChange={ (e) => setSurname(e.target.value)}    
                                />
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Email</label>
                                <input 
                                    type='email' 
                                    placeholder='Escribe tu email'
                                    name='email'
                                    className='form-control'
                                    value={email}
                                    onChange={ (e) => setEmail(e.target.value)}    
                                />
                            </div>
                            <button className='btn btn-success' onClick={ (e) => saveOrUpdateCustomer(e)}>Guardar</button>
                            &nbsp;
                            &nbsp;
                            <Link to={'/customers'} className='btn btn-danger'>Cancel</Link>
                        </form>
                    </div>
                </div>
            </div>
            
            
            
        </div>
    </div>
  )
}
export default AddCustomerComponent;