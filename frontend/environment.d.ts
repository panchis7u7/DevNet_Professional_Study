declare global {
    namespace NodeJS {
        interface ProcessEnv {
            NEXT_PUBLIC_BACKEND_PORT: number
            NEXT_PUBLIC_BACKEND_HOST: string
            NODE_ENV: 'development' | 'production';
        }
    }
}