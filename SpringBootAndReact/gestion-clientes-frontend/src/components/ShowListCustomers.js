import React, { useEffect, useState } from 'react'
import CustomerService from '../services/CustomerService';
import { Link } from 'react-router-dom';
//también estoy usando boostrap para no tener que personalizar yo todo es una libreria
//que la importe en el index.html
export const ShowListCustomers = () => {
    //creo mi hook y mi constante customers y lo inicializo como vacío
    const [customers,setCustomers] = useState([]);

    //uso el useEffect para obtner la api que voy a usar desde mi customerService
    useEffect(() => {
        customerList();
    },[])//uso corchetes llamo a la API una sola vez

    //método para listar clientes
    const customerList = () =>{
        //obtengo todos los customers, entonces seteo la response.data a mi const customers
        CustomerService.getAllCustomers().then((response) => {
            setCustomers(response.data);
        }).catch((error) => {
            console.log(error);
        })
    }
    //método para eliminar un cliente
    const deleteCustomer = (customerId) =>{
        CustomerService.deleteCustomer(customerId).then((response) => {
            customerList();
        }).catch((error) => {
            console.log(error)
        })
    }
    return (
        //en Link creo un botón de boostrap no creo literalmente el botón
    <div className='container'>
        <h2 className='text-center'>Lista de empleados</h2>
        <Link to={'/add-customer'} className='btn btn-primary mb-2'>Agregar Cliente</Link>
        <table className='table table-bordered table striped'>
            <thead>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
                <th>Acciones</th>
            </thead>
            <tbody>
                {
                    customers.map(customer => 
                        <tr key={customer.id}>
                            <td>{customer.id}</td>
                            <td>{customer.name}</td>
                            <td>{customer.surname}</td>
                            <td>{customer.email}</td>
                            <td>
                                <Link className='btn btn-info'to={`/edit-customer/${customer.id}`}>Actualizar</Link>
                                <button style={{marginLeft: '10px'}}className='btn btn-danger' onClick={() => deleteCustomer(customer.id)}>Eliminar</button>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>

    </div>
  );
  
}

export default ShowListCustomers;