;+function () {
	const HtmlWebpackPlugin = require('html-webpack-plugin')
	const path = require('path')

	// __dirname = /build/js/packages/fluid-react-playground
	const resourcesPath = path.resolve(__dirname, '../../../../modules/playground/resources-js')

	config.plugins.push(new HtmlWebpackPlugin({
		template: path.resolve(resourcesPath, 'index.html')
	}))
}()
