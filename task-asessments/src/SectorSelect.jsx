import { useState, useEffect } from 'react';
import PropTypes from 'prop-types';

const SectorSelect = ({ value, onChange }) => {
    const [sectorsList, setSectorsList] = useState([]);

    useEffect(() => {
        const fetchSectors = async () => {
            try {
                const response = await fetch('/api/v1/getData');
                if (response.ok) {
                    const data = await response.json();
                    setSectorsList(data.sectors);
                } else {
                    console.error('Failed to fetch sectors');
                }
            } catch (error) {
                console.error('Error fetching sectors', error);
            }
        };

        fetchSectors();
    }, []);

    return (
        <select value={value} onChange={onChange}>
            {sectorsList.map((sector) => (
                <option key={sector} value={sector}>
                    {sector}
                </option>
            ))}
        </select>
    );
};

SectorSelect.propTypes = {
    value: PropTypes.string.isRequired,
    onChange: PropTypes.func.isRequired,
};

export default SectorSelect;
