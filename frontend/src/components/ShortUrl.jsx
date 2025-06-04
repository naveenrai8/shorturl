export default function ShortUrl() {
    return (
        <>
            <form action="#" method="POST">
                <div className="mb-6">
                    <label htmlFor="username" className="block text-sm font-medium text-gray-700 mb-2">Username</label>
                    <input type="text" name="username" id="username"
                           className="w-full px-4 py-3 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 transition duration-150 ease-in-out"
                           placeholder="Enter your username" required/>
                </div>

                <div className="mb-6">
                    <label htmlFor="password" className="block text-sm font-medium text-gray-700 mb-2">Password</label>
                    <input type="password" name="password" id="password"
                           className="w-full px-4 py-3 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 transition duration-150 ease-in-out"
                           placeholder="Enter your password" required/>
                </div>

                <div className="mb-6">
                    <button type="submit"
                            className="w-full bg-indigo-600 hover:bg-indigo-700 text-white font-semibold py-3 px-4 rounded-lg shadow-md focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 transition duration-150 ease-in-out">
                        Login
                    </button>
                </div>
            </form>

            <div class="text-center">
                <p class="text-sm text-gray-600">
                    Don't have an account?
                    <a href="#" class="font-medium text-indigo-600 hover:text-indigo-500 hover:underline">
                        Create new account
                    </a>
                </p>
            </div>
        </>
    )
        ;
}