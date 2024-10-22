import Link from 'next/link';
import "./style.css";
const Home = () => (
    <div className='container'>
        <h1>Welcome</h1>
        <div className='button'>
            <Link href="/login">
                <button>Login</button>
            </Link>
        </div>
        <div className='button'>
            <Link href="/register">
                <button>Register</button>
            </Link>
        </div>
    </div>
);

export default Home;
