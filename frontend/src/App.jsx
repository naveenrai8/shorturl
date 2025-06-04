
import './App.css'
import ShortUrl from "./components/ShortUrl.jsx";

function App() {
    return (
        <>
            <div className="bg-white p-8 rounded-lg shadow-lg w-full max-w-md">
                <h1 className="text-2xl font-bold text-center text-gray-800 mb-8">Short Url from Long Url</h1>
                <ShortUrl></ShortUrl>
            </div>
        </>
    )
}

export default App
