import Form from './components/Form';
import './App.css';

const App = () => {
    return (
        <div className="AppContainer">
            <h1 className="headerText">Please enter your name and pick the Sectors you are currently involved in.</h1>
            <Form />
        </div>
    );
};

export default App;
