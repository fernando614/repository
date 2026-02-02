import './App.css';
import AddCustomerComponent from './components/AddCustomerComponent';
//las rutas siempre vienen en este clase App.js
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
//tengo que importar 'npm i axios' --save para establecer la conexión con mi backend
import ShowListCustomers from './components/ShowListCustomers';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
//npm i react-router-dom --save -> ese comando nos sirve para establecer las rutas en nuestra app
function App() {
  return (
    <div>
      <BrowserRouter>
        <HeaderComponent/>
          <div className='container'></div>
            <Routes>
              <Route exact path='/' element={<ShowListCustomers/>}></Route>
              <Route exact path='/customers' element={<ShowListCustomers/>}></Route>
              <Route exact path='/add-customer' element={<AddCustomerComponent/>}></Route>
              <Route exact path='/edit-customer/:id' element={<AddCustomerComponent/>}></Route>
            </Routes>
      </BrowserRouter>
      <FooterComponent/>
    </div>
  );
}

export default App;
