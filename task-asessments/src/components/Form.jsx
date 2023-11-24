import { useState, useEffect } from 'react';
import './Form.css';

const Form = () => {
    const [name, setName] = useState('');
    const [sectors, setSectors] = useState('');
    const [agreeTerms, setAgreeTerms] = useState(false);
    const [sectorsList, setSectorsList] = useState([]);

    useEffect(() => {
        const fetchSectors = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/v1/sectors');
                if (response.ok) {
                    const data = await response.json();
                    setSectorsList(data);
                } else {
                    console.error('Failed to fetch sectors');
                }
            } catch (error) {
                console.error('Error fetching sectors', error);
            }
        };

        fetchSectors();
    }, []);

    const handleSubmit = async (e) => {
        e.preventDefault();

        const formData = {
            name,
            sectors,
            agreeTerms,
        };

        try {

            const response = await fetch('http://localhost:8080/api/v1/saveData', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });

            if (response.ok) {
                console.log('Data submitted successfully!');
            } else {
                console.error('Failed to submit data');
            }
        } catch (error) {
            console.error('Error submitting data:', error);
        }
    };

    return (
    <div className="container-form">
      <h2>Data Form</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="name" className="label">
            Name:
          </label>
          <input
            className="input-field"
            type="text"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="sectors" className="label">
            Sectors:
          </label>
          <div className="sectorwrapper">
            <select
              className="selectbox"
              size={5}
              value={sectors}
              onChange={(e) => setSectors(e.target.value)}
            >
              {sectorsList.map((sector) => (
                <option key={sector.name} value={sector.name}>
                  {sector.name}
                </option>
              ))}
            </select>
          </div>
        </div>

        <div className="form-group">
          <label className="label">
            <input
              type="checkbox"
              checked={agreeTerms}
              onChange={() => setAgreeTerms(!agreeTerms)}
              required
            />
            Agree to terms
          </label>
        </div>

        <button className="button" type="submit">
          Save
        </button>
      </form>
    </div>
    );
};

export default Form;
