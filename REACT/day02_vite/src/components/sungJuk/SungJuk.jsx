import React, { useState } from 'react';
import sungJukList from './SungJukData';
import SungJukList from './SungJukList';
import '../../css/reset.css';
import '../../css/reset.css';
import '../../css/style.css';
import '../../css/sungJuk.css';

const SungJuk = () => {
    const [list, setList] = useState(sungJukList)
    return (
        <div>
            <section className='sungJukList'>
                <div className='inner'>
                    <SungJukList list = {list} />

                </div>
            </section>

        </div>
    );
};

export default SungJuk;